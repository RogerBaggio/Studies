package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.model.User;
import com.rojudo.spring_lab.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CUSTOM USER DETAILS SERVICE
 * 
 * Responsável por carregar usuário do banco para autenticação
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    private final UserRepository userRepository;
    
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.debug("Loading user by email: {}", email);
        
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> {
                log.warn("User not found with email: {}", email);
                return new UsernameNotFoundException("Usuário não encontrado com email: " + email);
            });
        
        log.debug("User loaded: {} - Active: {} - Locked: {}", 
            user.getEmail(), user.isEnabled(), user.isAccountNonLocked());
        
        return user;
    }
}