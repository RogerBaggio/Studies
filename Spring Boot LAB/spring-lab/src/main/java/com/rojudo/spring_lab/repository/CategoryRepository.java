package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CATEGORY REPOSITORY
 * 
 * Camada de acesso a dados para entidade Category
 * 
 * Spring Data JPA fornece implementação automática!
 * Basta estender JpaRepository e declarar métodos
 * 
 * MÉTODOS DERIVADOS (Spring Data JPA interpreta pelo nome):
 * - findByName(String name) → SELECT * FROM categories WHERE name = ?
 * - findByActiveTrue() → SELECT * FROM categories WHERE active = true
 * - findByParentIsNull() → SELECT * FROM categories WHERE parent_id IS NULL
 * 
 * @Repository → Indica bean de repositório, trata exceções JPA
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    // ===== MÉTODOS DERIVADOS (Spring Data JPA implementa automaticamente) =====
    
    /**
     * Busca categoria por nome (case-sensitive)
     * Usado no DataInitializer para encontrar categorias por nome
     */
    Optional<Category> findByName(String name);
    
    /**
     * Verifica se existe categoria com determinado nome
     * Útil para validações antes de criar
     */
    boolean existsByName(String name);
    
    /**
     * Busca todas categorias ativas
     */
    List<Category> findByActiveTrue();
    
    /**
     * Busca categorias inativas
     */
    List<Category> findByActiveFalse();
    
    /**
     * Busca categorias raiz (sem categoria pai)
     */
    List<Category> findByParentIsNull();
    
    /**
     * Busca categorias por categoria pai
     * Exemplo: todas sub-categorias de "Eletrônicos"
     */
    List<Category> findByParent(Category parent);
    
    /**
     * Busca categorias por nome ignorando maiúsculas/minúsculas
     */
    List<Category> findByNameContainingIgnoreCase(String name);
    
    // ===== QUERIES JPQL =====
    
    /**
     * Busca todas categorias com suas sub-categorias (carregamento eager)
     * Usado quando precisamos da hierarquia completa
     */
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.active = true")
    List<Category> findAllWithChildren();
    
    /**
     * Busca categoria por ID com suas sub-categorias
     */
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.id = :id")
    Optional<Category> findByIdWithChildren(@Param("id") Long id);
    
    /**
     * Busca categorias por nível na hierarquia
     * Implementado com CTE (Common Table Expression) nativo
     */
    @Query(value = """
        WITH RECURSIVE category_tree AS (
            SELECT id, name, parent_id, 0 as level
            FROM categories
            WHERE id = :categoryId
            UNION ALL
            SELECT c.id, c.name, c.parent_id, ct.level + 1
            FROM categories c
            INNER JOIN category_tree ct ON c.parent_id = ct.id
        )
        SELECT * FROM category_tree ORDER BY level
        """, nativeQuery = true)
    List<Object[]> findCategoryHierarchy(@Param("categoryId") Long categoryId);
    
    /**
     * Busca todas categorias descendentes de uma categoria
     * Exemplo: Todas sub-categorias de "Eletrônicos" (incluindo netos)
     */
    @Query(value = """
        WITH RECURSIVE descendants AS (
            SELECT id, name, parent_id
            FROM categories
            WHERE id = :categoryId
            UNION ALL
            SELECT c.id, c.name, c.parent_id
            FROM categories c
            INNER JOIN descendants d ON c.parent_id = d.id
        )
        SELECT * FROM descendants WHERE id != :categoryId
        """, nativeQuery = true)
    List<Object[]> findAllDescendants(@Param("categoryId") Long categoryId);
    
    // ===== QUERIES PARA ESTATÍSTICAS =====
    
    /**
     * Conta quantos produtos existem em cada categoria
     * Retorna: [category_name, product_count]
     */
    @Query("""
        SELECT c.name, COUNT(p.id) 
        FROM Category c 
        LEFT JOIN Product p ON p.category = c 
        GROUP BY c.id, c.name
        ORDER BY COUNT(p.id) DESC
        """)
    List<Object[]> countProductsByCategory();
    
    /**
     * Busca categorias com seus produtos (otimizado)
     */
    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.children WHERE c.active = true")
    List<Category> findAllActiveWithChildren();
}