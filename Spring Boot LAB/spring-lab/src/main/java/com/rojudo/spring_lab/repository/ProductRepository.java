package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.QueryHint;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
  REPOSITORY: Camada de acesso a dados
  
  POR QUE REPOSITORY?
  - Abstrai a persistência
  - Spring Data JPA implementa automaticamente
  - Métodos customizados podem ser adicionados
  - Facilita testes (mock)
  
  PRINCÍPIOS:
  - Interface (desacoplamento)
  - Nomes de métodos seguem convenção
  - @Repository para tratamento de exceções
  
  ESTA INTERFACE:
  - Estende JpaRepository para operações CRUD padrão
  - Estende ProductRepositoryCustom para queries complexas com Specification
  - Combina queries derivadas, JPQL e Native SQL
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    
    // ===== QUERIES BÁSICAS DERIVADAS =====
    // Spring Data JPA implementa baseado no nome do método
    // "where sku = ?1" - busca por SKU (único)
    
    /*
      Busca por SKU (único)
      Query derivada: "where sku = ?1"
     */
    Optional<Product> findBySku(String sku);
    
    /*
      Verifica existência por SKU
      Retorna boolean ao invés de entidade (mais eficiente)
     */
    boolean existsBySku(String sku);
    
    /*
      Busca por nome contendo (case insensitive)
      Query: "where lower(name) like lower(?1)"
     */
    List<Product> findByNameContainingIgnoreCase(String name);
    
    /*
      Busca produtos ativos com paginação
      Pageable automaticamente adiciona limit/offset
     */
    Page<Product> findByActiveTrue(Pageable pageable);
    
    // ===== QUERIES COM JPQL AVANÇADO =====
    // Para consultas mais complexas que as queries derivadas
    
    /**
     * Busca produtos com preço entre valores
     * Usando named parameters e paginação
     * Between é suportado nativamente no JPQL
     */
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByPriceRange(
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice,
        Pageable pageable
    );
    
    /**
     * Busca produtos com full-text search usando PostgreSQL
     * Usando native query para TSVECTOR (funcionalidade específica do banco)
     * Exemplo de como usar features específicas do SGBD
     */
    @Query(
        value = "SELECT * FROM products WHERE search_vector @@ to_tsquery('portuguese', :query)",
        nativeQuery = true
    )
    List<Product> fullTextSearch(@Param("query") String query);
    
    /**
     * Busca produtos com filtros dinâmicos
     * Parâmetros opcionais: se NULL, a condição é ignorada
     * Alternativa ao uso de Specifications para queries menos complexas
     */
    @Query("""
        SELECT p FROM Product p 
        WHERE (:category IS NULL OR p.category = :category)
          AND (:minPrice IS NULL OR p.price >= :minPrice)
          AND (:maxPrice IS NULL OR p.price <= :maxPrice)
          AND (:inStock IS NULL OR p.stockQuantity > 0)
          AND p.active = true
        ORDER BY p.createdAt DESC
        """)
    Page<Product> findWithFilters(
        @Param("category") String category,
        @Param("minPrice") BigDecimal minPrice,
        @Param("maxPrice") BigDecimal maxPrice,
        @Param("inStock") Boolean inStock,
        Pageable pageable
    );
    
    // ===== QUERIES COM HINTS DE PERFORMANCE =====
    // Otimizações de cache e performance
    
    @QueryHints({
        @QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "products"),
        @QueryHint(name = "org.hibernate.readOnly", value = "true")
    })
    @Query("SELECT p FROM Product p WHERE p.id = :id")
    Optional<Product> findByIdWithCache(@Param("id") Long id);
    
    // ===== OPERAÇÕES EM LOTE =====
    // Atualizações que afetam múltiplos registros
    
    @Modifying  // Indica que não é SELECT (executa UPDATE/DELETE)
    @Transactional  // Garante atomicidade da operação
    @Query("UPDATE Product p SET p.price = p.price * :multiplier WHERE p.category = :category")
    int bulkUpdatePriceByCategory(
        @Param("category") String category,
        @Param("multiplier") BigDecimal multiplier
    );
    
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.active = false WHERE p.id = :id")
    int softDelete(@Param("id") Long id);
    
    // ===== QUERIES COM AGREGADOS =====
    // Consultas que retornam dados calculados
    
    /**
      Estatísticas por categoria
      Usando GROUP BY com JPQL
      Retorna array de Object quando campos específicos
     */
    @Query("""
        SELECT 
            p.category, 
            COUNT(p), 
            AVG(p.price), 
            SUM(p.stockQuantity),
            MIN(p.price),
            MAX(p.price)
        FROM Product p 
        WHERE p.active = true 
        GROUP BY p.category
        """)
    List<Object[]> getCategoryStatistics();
    
    /**
      Estatísticas de criação de produtos agrupadas por data
      Usando FUNCTION() para chamar funções específicas do banco (DATE)
      Útil para dashboards e relatórios
     */
    @Query("""
        SELECT 
            FUNCTION('DATE', p.createdAt) as date,
            COUNT(p) as total,
            SUM(CASE WHEN p.active = true THEN 1 ELSE 0 END) as active
        FROM Product p 
        WHERE p.createdAt >= :since 
        GROUP BY FUNCTION('DATE', p.createdAt)
        ORDER BY date DESC
        """)
    List<Object[]> getProductCreationStats(@Param("since") LocalDateTime since);
    
    // ===== QUERIES NATIVAS AVANÇADAS =====
    // Quando precisa de performance ou features específicas do banco
    
    /*
      Busca produtos por hierarquia de categorias
      Usando Common Table Expression (CTE) recursiva
      Exemplo de feature específica do PostgreSQL/MySQL 8+
      Retorna produtos de uma categoria e todas suas subcategorias
     */
    @Query(
        value = """
            WITH RECURSIVE category_tree AS (
                SELECT id, name, parent_id, 1 as level
                FROM categories
                WHERE id = :categoryId
                UNION ALL
                SELECT c.id, c.name, c.parent_id, ct.level + 1
                FROM categories c
                INNER JOIN category_tree ct ON c.parent_id = ct.id
            )
            SELECT p.* FROM products p
            WHERE p.category_id IN (SELECT id FROM category_tree)
            AND p.active = true
            """,
        nativeQuery = true
    )
    List<Product> findByCategoryHierarchy(@Param("categoryId") Long categoryId);
    
    /**
      Busca produtos com full-text search usando PostgreSQL
      Alternativa mais performática que LIKE para buscas textuais
     */
    @Query(
        value = "SELECT * FROM products WHERE search_vector @@ to_tsquery('portuguese', :query)",
        nativeQuery = true
    )
    List<Product> fullTextSearchWindowFunctions(@Param("query") String query);
    
    // ===== QUERIES COM WINDOW FUNCTIONS =====
    // Análise avançada sem perder detalhes dos registros
    
    @Query(
        value = """
            SELECT 
                id, name, price, category,
                RANK() OVER (PARTITION BY category ORDER BY price DESC) as price_rank,
                PERCENT_RANK() OVER (ORDER BY price) as percentile
            FROM products 
            WHERE active = true
            """,
        nativeQuery = true
    )
    List<Object[]> getProductRankings();
    
    // ===== MÉTODOS ADICIONAIS DO REPOSITÓRIO ORIGINAL =====
    // Mantidos para compatibilidade e funcionalidades adicionais
    
    /**
      Busca produtos ativos por categoria
      Múltiplas condições: active = true AND category = ?
     */
    List<Product> findByActiveTrueAndCategory(String category);
    
    /**
      Busca produtos com preço entre valores (versão simples)
      Between é suportado nativamente
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    /**
      Busca produtos com estoque baixo
      JPQL usa a entity, não a tabela
     */
    @Query("SELECT p FROM Product p WHERE p.stockQuantity < :threshold AND p.active = true")
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
    
    /**
      Busca produtos com informações agregadas simplificadas
      Retorna array de Object quando campos específicos
     */
    @Query("""
        SELECT p.id, p.name, p.sku, p.price 
        FROM Product p 
        WHERE p.category = :category AND p.active = true
        ORDER BY p.price DESC
        """)
    List<Object[]> findProductSummariesByCategory(@Param("category") String category);
}