package com.rojudo.spring_lab.mapper;

import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/* IMPORTANTE:
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
    
    /* Converte Request para Entity
       IMPORTANTE: O request.category é uma String (nome da categoria), é necessario buscar o objeto Category no banco
     */
    public Product toEntity(ProductRequest request) {
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
    
    /* Converte Entity para Response
       IMPORTANTE: product.getCategory() retorna Category, é preciso extrair o nome como String para o DTO
     */
    public ProductResponse toResponse(Product product) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        // Extrai o nome da categoria (se existir) ou null
        String categoryName = product.getCategory() != null 
            ? product.getCategory().getName() 
            : null;
        
        return ProductResponse.builder()
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
    
    /* Atualiza entity existente com dados do request (patch) 
       IMPORTANTE: Mesma lógica de conversão String → Category
     */
    public void updateEntity(Product product, ProductRequest request) {
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