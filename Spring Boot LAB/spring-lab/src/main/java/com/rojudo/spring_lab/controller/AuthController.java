package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.request.AuthLoginRequest;
import com.rojudo.spring_lab.dto.request.AuthRegisterRequest;
import com.rojudo.spring_lab.dto.response.AuthLoginResponse;
import com.rojudo.spring_lab.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Autenticação", description = "Endpoints de autenticação e registro")
public class AuthController {
    
    private final AuthService authService;
    
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login", description = "Autentica usuário e retorna token JWT")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    public ResponseEntity<AuthLoginResponse> login(@Valid @RequestBody AuthLoginRequest request) {
        AuthLoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
    @Operation(summary = "Registro", description = "Registra novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @ApiResponse(responseCode = "409", description = "Email já cadastrado")
    public ResponseEntity<AuthLoginResponse> register(@Valid @RequestBody AuthRegisterRequest request) {
        AuthLoginResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("/refresh")
    @Operation(summary = "Refresh Token", description = "Renova token JWT")
    public ResponseEntity<AuthLoginResponse> refresh(@RequestHeader("Authorization") String refreshToken) {
        AuthLoginResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/logout")
    @Operation(summary = "Logout", description = "Realiza logout (invalida token no client)")
    public ResponseEntity<Void> logout() {
        // Cliente deve remover o token localmente
        // Como é stateless, não precisamos invalidar no servidor
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/change-password")
    @Operation(summary = "Alterar senha", description = "Altera senha do usuário autenticado")
    public ResponseEntity<Void> changePassword(
            @RequestHeader("Authorization") String token,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        authService.changePassword(token, oldPassword, newPassword);
        return ResponseEntity.noContent().build();
    }
}