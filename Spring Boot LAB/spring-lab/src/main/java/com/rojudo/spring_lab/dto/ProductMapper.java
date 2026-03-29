package com.rojudo.spring_lab.dto;

import com.rojudo.spring_lab.model.Product;
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
 */
@Component
public class ProductMapper {
    
    // Converte Request DTO para Entity
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
        if (request.category() != null) {
            product.setCategory(request.category());
        }
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
        
        return product;
    }
    
    // Converte Entity para Response DTO
    public ProductResponseDTO toResponse(Product product) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        return ProductResponseDTO.builder()
            .id(product.getId())
            .sku(product.getSku())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .category(product.getCategory())
            .stockQuantity(product.getStockQuantity())
            .active(product.getActive())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .available(product.isAvailable())
            .priceFormatted(currencyFormatter.format(product.getPrice()))
            .build();
    }
    
    // Atualiza entity existente com dados do request (patch)
    public void updateEntity(Product product, ProductRequestDTO request) {
        if (request.name() != null) {
            product.setName(request.name());
        }
        if (request.description() != null) {
            product.setDescription(request.description());
        }
        /*if (request.price() != null) {
            product.updatePrice(request.price()); // Usa método de negócio!
        }*/
        if (request.category() != null) {
            product.setCategory(request.category());
        }
        if (request.stockQuantity() != null) {
            product.setStockQuantity(request.stockQuantity());
        }
    }
}