package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.dto.request.AuthLoginRequest;
import com.rojudo.spring_lab.dto.request.AuthRegisterRequest;
import com.rojudo.spring_lab.dto.response.AuthLoginResponse;
import com.rojudo.spring_lab.dto.response.UserInfoResponse;
import com.rojudo.spring_lab.domain.Role;
import com.rojudo.spring_lab.domain.User;
import com.rojudo.spring_lab.repository.RoleRepository;
import com.rojudo.spring_lab.repository.UserRepository;
import com.rojudo.spring_lab.config.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthService {
    
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    
    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       UserRepository userRepository,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService,
                       UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    
    /**
     * Login - Autentica usuário e gera token
     */
    public AuthLoginResponse login(AuthLoginRequest request) {
        log.info("Login attempt for user: {}", request.email());
        
        try {
            // Autentica usando AuthenticationManager
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.email(),
                    request.password()
                )
            );
            
            // Carrega usuário completo
            User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));
            
            // Registra login bem-sucedido
            user.recordSuccessfulLogin();
            userRepository.save(user);
            
            // Gera token
            String token = jwtService.generateToken(authentication);
            
            log.info("User logged in successfully: {}", user.getEmail());
            
            return buildLoginResponse(token, user);
            
        } catch (BadCredentialsException e) {
            // Registra tentativa falha
            userRepository.findByEmail(request.email()).ifPresent(user -> {
                user.incrementFailedAttempts();
                userRepository.save(user);
                log.warn("Failed login attempt for user: {}. Attempts: {}", 
                    user.getEmail(), user.getFailedAttempts());
            });
            
            log.warn("Invalid credentials for user: {}", request.email());
            throw new BadCredentialsException("Email ou senha inválidos");
        }
    }
    
    /**
     * Registro de novo usuário
     */
    public AuthLoginResponse register(AuthRegisterRequest request) {
        log.info("Register attempt for user: {}", request.email());
        
        // Verifica se email já existe
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        // Cria novo usuário - Usar construtor público em vez de new User()
        User user = new User(
            request.email(),
            passwordEncoder.encode(request.password()),
            request.fullName()
        );
        user.setPhone(request.phone());
        user.setActive(true);           // Em desenvolvimento, já ativo
        user.setEmailVerified(true);    // Em desenvolvimento, já verificado
        user.setAccountLocked(false);   // Em desenvolvimento, já desbloqueado
        user.setFailedAttempts(0);

        // Atribui role padrão USER
        Role defaultRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(Set.of(defaultRole));
        
        User savedUser = userRepository.save(user);
        
        log.info("User registered successfully: {}", savedUser.getEmail());
        
        // Autentica e gera token
        UserDetails userDetails = savedUser;  // User implementa UserDetails
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            userDetails,                    // ← UserDetails
            request.password(),             // ← Credenciais
            userDetails.getAuthorities()    // ← Authorities
        );
        
        String token = jwtService.generateToken(authentication);
        
        return buildLoginResponse(token, savedUser);
    }
    
    /**
     * Refresh token
     */
    public AuthLoginResponse refreshToken(String token) {
        // Remove prefixo "Bearer " se existir
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        String username = jwtService.extractUsername(token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        if (jwtService.isTokenValid(token, userDetails)) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
            );


            String newToken = jwtService.generateToken(authentication);
            
            User user = userRepository.findByEmail(username).orElseThrow();
            return buildLoginResponse(newToken, user);
        }
        
        throw new RuntimeException("Invalid refresh token");
    }
    
    /**
     * Altera senha
     */
    public void changePassword(String token, String oldPassword, String newPassword) {
        String username = jwtService.extractUsername(token.replace("Bearer ", ""));
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new BadCredentialsException("Senha atual inválida");
        }
        
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        
        log.info("Password changed for user: {}", user.getEmail());
    }
    
    /**
     * Constrói resposta de login
     */
    private AuthLoginResponse buildLoginResponse(String token, User user) {
        return new AuthLoginResponse(
            token,
            new UserInfoResponse(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getRoles().stream()
                    .map(Role::getName)
                    .collect(Collectors.toList()),
                user.getAuthorities().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList())
            )
        );
    }
}