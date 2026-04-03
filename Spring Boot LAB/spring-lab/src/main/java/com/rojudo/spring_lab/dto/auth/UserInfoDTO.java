package com.rojudo.spring_lab.dto.auth;

import java.util.List;

/**
 * USER INFO DTO
 * 
 * Data Transfer Object para informações do usuário na resposta de autenticação
 * 
 * POR QUE USAR DTO SEPARADO?
 * - Separação de responsabilidades: LoginResponseDTO não deve conter inner classes complexas
 * - Reusabilidade: Pode ser usado em outros endpoints que retornam dados do usuário
 * - Testabilidade: Mais fácil de testar isoladamente
 * - Imutabilidade: Record garante que os dados não sejam alterados após criação
 * 
 * PRINCÍPIOS:
 * - Record: Imutável, gera automaticamente equals, hashCode, toString
 * - Campos: Apenas o necessário para o cliente, sem expor dados sensíveis
 */
public record UserInfoDTO(
    /**
     * ID único do usuário
     */
    Long id,
    
    /**
     * Email do usuário (usado como username)
     */
    String email,
    
    /**
     * Nome completo do usuário
     */
    String fullName,
    
    /**
     * Lista de roles do usuário (ex: ROLE_ADMIN, ROLE_USER)
     */
    List<String> roles,
    
    /**
     * Lista de permissões granulares (ex: PRODUCT_READ, PRODUCT_CREATE)
     */
    List<String> permissions
) {
    /**
     * Construtor customizado para validação
     */
    public UserInfoDTO {
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
    
    /**
     * Método utilitário para verificar se usuário tem um role específico
     */
    public boolean hasRole(String role) {
        return roles != null && roles.contains(role);
    }
    
    /**
     * Método utilitário para verificar se usuário tem uma permissão específica
     */
    public boolean hasPermission(String permission) {
        return permissions != null && permissions.contains(permission);
    }
    
    /**
     * Retorna representação simplificada para logs
     */
    @Override
    public String toString() {
        return String.format("UserInfoDTO{id=%d, email='%s', fullName='%s', roles=%s}",
            id, email, fullName, roles);
    }
}