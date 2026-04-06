package com.rojudo.spring_lab.validation;

import com.rojudo.spring_lab.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueSkuValidator implements ConstraintValidator<UniqueSku, String> {
    
    @Autowired
    private ProductRepository productRepository;
    
    private long ignoreId;
    
    @Override
    public void initialize(UniqueSku constraintAnnotation) {
        this.ignoreId = constraintAnnotation.ignoreId();
    }
    
    @Override
    public boolean isValid(String sku, ConstraintValidatorContext context) {
        if (sku == null || sku.isBlank()) {
            return true; // Deixar @NotBlank lidar com isso
        }
        
        if (ignoreId > 0) {
            // Para UPDATE: verificar se existe outro produto com mesmo SKU
            return productRepository.findBySku(sku)
                .map(product -> product.getId().equals(ignoreId))
                .orElse(true);
        }
        
        // Para CREATE: verificar se SKU já existe
        return !productRepository.existsBySku(sku);
    }
}