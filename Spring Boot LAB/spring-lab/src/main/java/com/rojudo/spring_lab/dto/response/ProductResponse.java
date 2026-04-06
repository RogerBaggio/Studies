package com.rojudo.spring_lab.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
    Long id,
    String sku,
    String name,
    String description,
    BigDecimal price,
    String category,
    Integer stockQuantity,
    Boolean active,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    
    // Campos calculados/dinâmicos
    Boolean available,
    String priceFormatted
    
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder { // Builder pattern manual: Construtor menos confuso, nome de campos explícitos, imutabilidade mantida
        private Long id;
        private String sku;
        private String name;
        private String description;
        private BigDecimal price;
        private String category;
        private Integer stockQuantity;
        private Boolean active;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private Boolean available;
        private String priceFormatted;
        
        public Builder id(Long id) { this.id = id; return this; }
        public Builder sku(String sku) { this.sku = sku; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder price(BigDecimal price) { this.price = price; return this; }
        public Builder category(String category) { this.category = category; return this; }
        public Builder stockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; return this; }
        public Builder active(Boolean active) { this.active = active; return this; }
        public Builder createdAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder updatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; return this; }
        public Builder available(Boolean available) { this.available = available; return this; }
        public Builder priceFormatted(String priceFormatted) { this.priceFormatted = priceFormatted; return this; }
        
        public ProductResponse build() {
            return new ProductResponse(
                id, sku, name, description, price, category,
                stockQuantity, active, createdAt, updatedAt,
                available, priceFormatted
            );
        }
    }
}