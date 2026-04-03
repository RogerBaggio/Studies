package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * PERMISSION REPOSITORY
 * 
 * Camada de acesso a dados para entidade Permission
 * 
 * Permissões são granulares e representam ações específicas no sistema:
 * - PRODUCT_READ: Pode visualizar produtos
 * - PRODUCT_CREATE: Pode criar produtos
 * - PRODUCT_UPDATE: Pode editar produtos
 * - PRODUCT_DELETE: Pode deletar produtos
 * 
 * Usado pelo Spring Security para verificar @PreAuthorize("hasAuthority('PRODUCT_READ')")
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    
    // ===== MÉTODOS DERIVADOS =====
    
    /**
     * Busca permissão por nome
     * Usado no DataInitializer para encontrar permissões por nome
     * Exemplo: findByName("PRODUCT_READ")
     */
    Optional<Permission> findByName(String name);
    
    /**
     * Verifica se permissão existe
     */
    boolean existsByName(String name);
    
    /**
     * Busca múltiplas permissões por nomes
     * Usado no DataInitializer para atribuir permissões a roles
     * Exemplo: findAllByNameIn(["PRODUCT_READ", "PRODUCT_CREATE"])
     */
    List<Permission> findAllByNameIn(List<String> names);
    
    /**
     * Busca todas permissões que contêm determinada string no nome
     * Exemplo: findAllByNameContaining("PRODUCT") → todas permissões de produto
     */
    List<Permission> findByNameContaining(String keyword);
    
    /**
     * Busca permissões por descrição
     */
    List<Permission> findByDescriptionContainingIgnoreCase(String description);
    
    // ===== QUERIES JPQL =====
    
    /**
     * Busca todas permissões associadas a um usuário específico
     * Útil para montar lista de authorities para o Spring Security
     * 
     * A query navega na direção correta do relacionamento:
     * User (dono) → roles → permissions
     */
    @Query("""
    SELECT DISTINCT p 
    FROM User u 
    JOIN u.roles r 
    JOIN r.permissions p 
    WHERE u.id = :userId
    """)
Set<Permission> findPermissionsByUserId(@Param("userId") Long userId);
    
    /**
     * Busca todas permissões associadas a uma role específica
     */
    @Query("SELECT r.permissions FROM Role r WHERE r.id = :roleId")
    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);
    
    /**
     * Busca permissões agrupadas por categoria (prefixo do nome)
     * Exemplo: Permissões começando com "PRODUCT_" são do módulo Produtos
     */
    @Query("""
        SELECT 
            SUBSTRING(p.name, 1, POSITION('_' IN p.name) - 1) as module,
            COUNT(p) as count
        FROM Permission p
        GROUP BY module
        ORDER BY module
        """)
    List<Object[]> countPermissionsByModule();
    
    // ===== QUERIES NATIVAS =====
    
    /**
     * Busca permissões de um usuário via SQL nativo (mais performático)
     * Usado internamente pelo Spring Security
     */
    @Query(value = """
        SELECT DISTINCT p.* 
        FROM permissions p
        JOIN role_permissions rp ON p.id = rp.permission_id
        JOIN user_roles ur ON rp.role_id = ur.role_id
        WHERE ur.user_id = :userId
        """, nativeQuery = true)
    List<Permission> findUserPermissionsNative(@Param("userId") Long userId);
    
    // ===== MÉTODOS PARA INICIALIZAÇÃO =====
    
    /**
     * Verifica se todas as permissões essenciais existem
     * Usado para validação na inicialização
     */
    @Query("""
        SELECT COUNT(p) FROM Permission p 
        WHERE p.name IN ('PRODUCT_READ', 'PRODUCT_CREATE', 'PRODUCT_UPDATE', 'PRODUCT_DELETE')
        """)
    long countEssentialPermissions();
}