package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // ===== MÉTODOS DERIVADOS =====
    // Spring Data JPA implementa baseado no nome do método
    
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
      Busca produtos ativos por categoria
      Múltiplas condições: active = true AND category = ?
     */
    List<Product> findByActiveTrueAndCategory(String category);
    
    /**
      Busca produtos com preço entre valores
      Between é suportado nativamente
     */
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
    
    /*
      Busca com paginação
      Pageable automaticamente adiciona limit/offset
     */
    Page<Product> findByActiveTrue(Pageable pageable);
    
    // ===== QUERIES JPQL =====
    // Para consultas mais complexas
    
    /**
      Busca produtos com estoque baixo
      JPQL usa a entity, não a tabela
     */
    @Query("SELECT p FROM Product p WHERE p.stockQuantity < :threshold AND p.active = true")
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
    
    /**
      Atualização em lote com JPQL
      @Modifying para operações que não são SELECT
      @Transactional para garantir atomicidade
     */
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.active = false WHERE p.id = :id")
    int deactivateProduct(@Param("id") Long id);
    
    /*
      Busca produtos com informações agregadas
      Retorna array de Object quando campos específicos
     */
    @Query("""
        SELECT p.id, p.name, p.sku, p.price 
        FROM Product p 
        WHERE p.category = :category AND p.active = true
        ORDER BY p.price DESC
        """)
    List<Object[]> findProductSummariesByCategory(@Param("category") String category);
    
    // ===== NATIVE QUERIES =====
    // Quando precisa de performance ou features específicas do banco
    
    /*
      Native query para funcionalidades específicas do banco
      Exemplo: FULLTEXT search no MySQL
     */
    @Query(value = """
        SELECT * FROM products 
        WHERE MATCH(name, description) AGAINST(:keyword IN NATURAL LANGUAGE MODE)
        AND active = 1
        LIMIT :limit
        """, nativeQuery = true)
    List<Product> searchProductsFullText(@Param("keyword") String keyword, @Param("limit") int limit);
    
    /*
      Estatísticas por categoria
      Usando GROUP BY com native query
     */
    @Query(value = """
        SELECT 
            category,
            COUNT(*) as total,
            AVG(price) as avg_price,
            SUM(stock_quantity) as total_stock
        FROM products 
        WHERE active = 1
        GROUP BY category
        """, nativeQuery = true)
    List<Object[]> getCategoryStatistics();
}