package com.rojudo.spring_lab.dto;

import com.rojudo.spring_lab.model.Category;
import com.rojudo.spring_lab.model.Product;
import com.rojudo.spring_lab.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/*
  MAPPER: Converte entre Entity e DTO
  
  POR QUE MAPPER SEPARADO?
  - Separa responsabilidade de conversão
  - Lógica de transformação centralizada
  - Fácil de testar
  - Permite diferentes representações
  
  IMPORTANTE: Agora com suporte a Category!
  - Request DTO recebe String (nome da categoria)
  - Entity trabalha com Category (objeto JPA)
  - Response DTO retorna String (nome da categoria)
 */
@Component
public class ProductMapper {
    
    private final CategoryRepository categoryRepository;
    
    @Autowired
    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    // ============================================
    // REQUEST → ENTITY
    // ============================================
    
    /**
     * Converte Request DTO para Entity
     * 
     * IMPORTANTE: O request.category é uma String (nome da categoria)
     * Precisamos buscar o objeto Category no banco
     */
    public Product toEntity(ProductRequestDTO request) {
        Product product = new Product(
            request.sku(),
            request.name(),
            request.price()
        );
        
        // Campos opcionais
        if (request.description() != null) {
            product.setDescription(request.description());
        }
        
        // Converte String (nome da categoria) para Category (objeto JPA)
        if (request.category() != null && !request.category().isBlank()) {
            Category category = categoryRepository.findByName(request.category())
                .orElseThrow(() -> new RuntimeException(
                    "Categoria não encontrada: " + request.category()
                ));
            product.setCategory(category);
        }
        
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
        
        return product;
    }
    
    // ============================================
    // ENTITY → RESPONSE
    // ============================================
    
    /**
     * Converte Entity para Response DTO
     * 
     * IMPORTANTE: product.getCategory() retorna Category
     * Precisamos extrair o nome como String para o DTO
     */
    public ProductResponseDTO toResponse(Product product) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        // Extrai o nome da categoria (se existir) ou null
        String categoryName = product.getCategory() != null 
            ? product.getCategory().getName() 
            : null;
        
        return ProductResponseDTO.builder()
            .id(product.getId())
            .sku(product.getSku())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .category(categoryName)  // ← String, não Category!
            .stockQuantity(product.getStockQuantity())
            .active(product.getActive())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .available(product.isAvailable())
            .priceFormatted(currencyFormatter.format(product.getPrice()))
            .build();
    }
    
    // ============================================
    // UPDATE ENTITY (PATCH)
    // ============================================
    
    /**
     * Atualiza entity existente com dados do request (patch)
     * 
     * IMPORTANTE: Mesma lógica de conversão String → Category
     */
    public void updateEntity(Product product, ProductRequestDTO request) {
        if (request.name() != null) {
            product.setName(request.name());
        }
        if (request.description() != null) {
            product.setDescription(request.description());
        }
        
        // Converte String (nome da categoria) para Category (objeto JPA)
        if (request.category() != null) {
            if (request.category().isBlank()) {
                product.setCategory(null);  // Remove categoria
            } else {
                Category category = categoryRepository.findByName(request.category())
                    .orElseThrow(() -> new RuntimeException(
                        "Categoria não encontrada: " + request.category()
                    ));
                product.setCategory(category);
            }
        }
        
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
    }
}