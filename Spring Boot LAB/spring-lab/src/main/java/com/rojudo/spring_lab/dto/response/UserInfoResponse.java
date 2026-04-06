package com.rojudo.spring_lab.dto.response;

import java.util.List;

public record UserInfoResponse(
    Long id, // ID único do usuário
    String email, // Email do usuário (usado como username)
    String fullName, // Nome completo do usuário
    List<String> roles, // Lista de roles do usuário (ex: ROLE_ADMIN, ROLE_USER)
    List<String> permissions // Lista de permissões granulares (ex: PRODUCT_READ, PRODUCT_CREATE)
) {
    
    // Construtor customizado para validação
    public UserInfoResponse { 
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or blank");
        }
    }
    
    // Método utilitário para verificar se usuário tem um role específico
    public boolean hasRole(String role) {
        return roles != null && roles.contains(role);
    }
    
    // Método utilitário para verificar se usuário tem uma permissão específica
    public boolean hasPermission(String permission) {
        return permissions != null && permissions.contains(permission);
    }
    
    // Retorna representação simplificada para logs
    @Override
    public String toString() {
        return String.format("UserInfoDTO{id=%d, email='%s', fullName='%s', roles=%s}",
            id, email, fullName, roles);
    }
}