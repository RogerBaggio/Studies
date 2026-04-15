package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.exception.ResourceNotFoundException;
import com.rojudo.spring_lab.mapper.ProductMapper;
import com.rojudo.spring_lab.repository.CategoryRepository;
import com.rojudo.spring_lab.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Habilita mocks do Mockito no JUnit 5
@DisplayName("ProductService - Testes de Unidade")
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks  // Cria instância do ProductService e injeta os mocks
    private ProductService productService;

    private Product product;
    private ProductRequest request;
    private ProductResponse response;
    private Category category;

    @BeforeEach  // Executa antes de cada teste
    void setUp() {
        category = new Category("Eletrônicos");
        setIdViaReflection(category, 1L);

        product = new Product("SKU-001", "Notebook", new BigDecimal("3500.00"));
        setIdViaReflection(product, 1L);
        product.setCategory(category);

        request = new ProductRequest(
            "SKU-001", "Notebook", "Notebook Gamer",
            new BigDecimal("3500.00"), "Eletrônicos", 10
        );

        response = ProductResponse.builder()
            .id(1L)
            .sku("SKU-001")
            .name("Notebook")
            .price(new BigDecimal("3500.00"))
            .category("Eletrônicos")
            .stockQuantity(10)
            .build();
    }

    // Método auxiliar para definir ID via reflexão (apenas para testes)
    private void setIdViaReflection(Object entity, Long id) {
        try {
            var field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível definir ID via reflexão", e);
        }
    }

    // ===== TESTES DE CRIAÇÃO (CREATE) =====
    
    @Nested
    @DisplayName("Testes do método create()")
    class CreateTests {

        @Test
        @DisplayName("Deve criar produto com sucesso quando SKU é único")
        void shouldCreateProductWhenSkuIsUnique() {
            // Arrange (preparação)
            when(productRepository.existsBySku(anyString())).thenReturn(false);
            when(categoryRepository.findByName("Eletrônicos")).thenReturn(Optional.of(category));
            when(productMapper.toEntity(request)).thenReturn(product);
            when(productRepository.save(any(Product.class))).thenReturn(product);
            when(productMapper.toResponse(product)).thenReturn(response);

            // Act (execução)
            ProductResponse result = productService.create(request);

            // Assert (verificação)
            assertThat(result).isNotNull();
            assertThat(result.sku()).isEqualTo("SKU-001");
            verify(productRepository, times(1)).save(product);
        }

        @Test
        @DisplayName("Deve lançar exceção quando SKU já existe")
        void shouldThrowExceptionWhenSkuAlreadyExists() {
            when(productRepository.existsBySku("SKU-001")).thenReturn(true);

            assertThatThrownBy(() -> productService.create(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Produto com SKU SKU-001 já existe");

            verify(productRepository, never()).save(any());
        }

        @Test
        @DisplayName("Deve lançar exceção quando categoria não existe")
        void shouldThrowExceptionWhenCategoryNotFound() {
            when(productRepository.existsBySku(anyString())).thenReturn(false);
            when(categoryRepository.findByName("Eletrônicos")).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.create(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Categoria não encontrada");
        }
    }

    // ===== TESTES DE LEITURA (READ) =====
    
    @Nested
    @DisplayName("Testes do método findById()")
    class FindByIdTests {

        @Test
        @DisplayName("Deve retornar produto quando ID existe")
        void shouldReturnProductWhenIdExists() {
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));
            when(productMapper.toResponse(product)).thenReturn(response);

            ProductResponse result = productService.findById(1L);

            assertThat(result).isNotNull();
            assertThat(result.id()).isEqualTo(1L);
        }

        @Test
        @DisplayName("Deve lançar ResourceNotFoundException quando ID não existe")
        void shouldThrowNotFoundWhenIdDoesNotExist() {
            when(productRepository.findById(999L)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> productService.findById(999L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Produto com ID 999 não encontrado");
        }
    }

    // ===== TESTES DE ATUALIZAÇÃO DE ESTOQUE =====
    
    @Nested
    @DisplayName("Testes do método updateStock()")
    class UpdateStockTests {

        @Test
        @DisplayName("Deve aumentar estoque com sucesso")
        void shouldIncreaseStockSuccessfully() {
            product.setStockQuantity(10);
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));

            productService.updateStock(1L, 5);

            assertThat(product.getStockQuantity()).isEqualTo(15);
            verify(productRepository).save(product);
        }

        @Test
        @DisplayName("Deve lançar exceção quando estoque fica negativo")
        void shouldThrowExceptionWhenStockGoesNegative() {
            product.setStockQuantity(3);
            when(productRepository.findById(1L)).thenReturn(Optional.of(product));

            assertThatThrownBy(() -> productService.updateStock(1L, -10))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Estoque insuficiente");
        }
    }

    // ===== TESTES DE BUSCA COM PAGINAÇÃO =====
    
    @Nested
    @DisplayName("Testes de paginação")
    class PaginationTests {

        @Test
        @DisplayName("Deve retornar página de produtos ativos")
        void shouldReturnPageOfActiveProducts() {
            Pageable pageable = PageRequest.of(0, 10);
            Page<Product> productPage = new PageImpl<>(List.of(product));
            Page<ProductResponse> responsePage = new PageImpl<>(List.of(response));

            when(productRepository.findByActiveTrue(pageable)).thenReturn(productPage);
            when(productMapper.toResponse(any(Product.class))).thenReturn(response);

            Page<ProductResponse> result = productService.findActiveProducts(pageable);

            assertThat(result).isNotNull();
            assertThat(result.getContent()).hasSize(1);
        }
    }
}