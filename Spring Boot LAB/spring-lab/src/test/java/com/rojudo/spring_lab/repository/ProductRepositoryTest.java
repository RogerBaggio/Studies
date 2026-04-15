package com.rojudo.spring_lab.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Usa banco REAL
@ActiveProfiles("dev")  // Usa configurações do application-dev.yml (localhost:5432)
@DisplayName("ProductRepository - Testes com PostgreSQL do Docker Compose")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Category category;
    private Product product;

    @BeforeEach
    void setUp() {
        // Cria e persiste uma categoria
        category = new Category("Eletrônicos", "Produtos eletrônicos");
        category = categoryRepository.save(category);

        // Cria um produto associado à categoria
        product = new Product("SKU-TEST-001", "Notebook Teste", new BigDecimal("2500.00"));
        product.setDescription("Notebook para testes");
        product.setCategory(category);
        product.setStockQuantity(10);
        product = productRepository.save(product);
        
        entityManager.flush();
        entityManager.clear();
    }

    @Nested
    @DisplayName("Queries derivadas (Spring Data)")
    class DerivedQueriesTests {

        @Test
        @DisplayName("findBySku - Deve encontrar produto por SKU")
        void shouldFindProductBySku() {
            Optional<Product> found = productRepository.findBySku("SKU-TEST-001");
            assertThat(found).isPresent();
            assertThat(found.get().getName()).isEqualTo("Notebook Teste");
        }

        @Test
        @DisplayName("existsBySku - Deve retornar true para SKU existente")
        void shouldReturnTrueWhenSkuExists() {
            boolean exists = productRepository.existsBySku("SKU-TEST-001");
            assertThat(exists).isTrue();
        }

        @Test
        @DisplayName("existsBySku - Deve retornar false para SKU inexistente")
        void shouldReturnFalseWhenSkuDoesNotExist() {
            boolean exists = productRepository.existsBySku("SKU-INEXISTENTE");
            assertThat(exists).isFalse();
        }

        @Test
        @DisplayName("findByActiveTrue - Deve retornar apenas produtos ativos")
        void shouldReturnOnlyActiveProducts() {
            Pageable pageable = PageRequest.of(0, 10);
            product.setActive(false);
            productRepository.save(product);
            entityManager.flush();
            entityManager.clear();

            Page<Product> activeProducts = productRepository.findByActiveTrue(pageable);
            assertThat(activeProducts.getContent()).isEmpty();
        }
    }

    @Nested
    @DisplayName("Queries JPQL customizadas")
    class JpqlQueriesTests {

        @Test
        @DisplayName("findByPriceRange - Deve encontrar produtos na faixa de preço")
        void shouldFindProductsInPriceRange() {
            Pageable pageable = PageRequest.of(0, 10);
            Page<Product> result = productRepository.findByPriceRange(
                new BigDecimal("2000.00"), 
                new BigDecimal("3000.00"), 
                pageable
            );
            assertThat(result.getContent()).hasSize(1);
        }

        @Test
        @DisplayName("findLowStockProducts - Deve encontrar produtos com estoque baixo")
        void shouldFindLowStockProducts() {
            product.setStockQuantity(3);
            productRepository.save(product);
            List<Product> lowStock = productRepository.findLowStockProducts(5);
            assertThat(lowStock).hasSize(1);
        }
    }

    @Nested
    @DisplayName("Constraints e validações de banco")
    class ConstraintsTests {

        @Test
        @DisplayName("SKU único - Não deve permitir duplicação")
        void shouldNotAllowDuplicateSku() {
            Product duplicate = new Product("SKU-TEST-001", "Produto Duplicado", new BigDecimal("100.00"));
            assertThatThrownBy(() -> productRepository.saveAndFlush(duplicate))
                .isInstanceOf(org.springframework.dao.DataIntegrityViolationException.class);
        }
    }

    @Nested
    @DisplayName("Paginação e ordenação")
    class PaginationTests {

        @Test
        @DisplayName("Deve paginar resultados corretamente")
        void shouldPaginateResults() {
            for (int i = 1; i <= 5; i++) {
                Product p = new Product("SKU-PAGE-" + i, "Produto " + i, new BigDecimal("100.00"));
                p.setCategory(category);
                productRepository.save(p);
            }
            entityManager.flush();
            entityManager.clear();

            Pageable firstPage = PageRequest.of(0, 3);
            Page<Product> page = productRepository.findAll(firstPage);
            assertThat(page.getContent()).hasSize(3);
        }
    }
}