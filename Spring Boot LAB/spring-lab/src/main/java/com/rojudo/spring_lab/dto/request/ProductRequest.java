package com.rojudo.spring_lab.dto.request;

import com.rojudo.spring_lab.validation.UniqueSku;
import com.rojudo.spring_lab.validation.ValidationGroups;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequest(
    
    // CREATE: SKU obrigatório e único
    // UPDATE: SKU opcional, mas se fornecido deve ser único (ignorando o próprio ID)
    @NotBlank(groups = ValidationGroups.OnCreate.class, message = "{product.sku.notblank}")
    @Size(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class}, 
          min = 3, max = 50, message = "{product.sku.size}")
    @Pattern(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
             regexp = "^[A-Z0-9-]+$", message = "{product.sku.pattern}")
    @UniqueSku(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
               message = "{product.sku.unique}")
    String sku,
    
    // CREATE: nome obrigatório
    // UPDATE: nome opcional
    @NotBlank(groups = ValidationGroups.OnCreate.class, message = "{product.name.notblank}")
    @Size(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
          min = 3, max = 200, message = "{product.name.size}")
    String name,
    
    @Size(max = 1000, message = "{product.description.size}")
    String description,
    
    // CREATE: preço obrigatório
    // UPDATE: preço opcional (se não fornecido, mantém o atual)
    @NotNull(groups = ValidationGroups.OnCreate.class, message = "{product.price.notnull}")
    @DecimalMin(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
                value = "0.01", message = "{product.price.min}")
    @DecimalMax(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
                value = "999999.99", message = "{product.price.max}")
    BigDecimal price,
    
    @Size(max = 100, message = "{product.category.size}")
    String category,
    
    @Min(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
         value = 0, message = "{product.stock.min}")
    @Max(groups = {ValidationGroups.OnCreate.class, ValidationGroups.OnUpdate.class},
         value = 999999, message = "{product.stock.max}")
    Integer stockQuantity
    
) {
    // Validação condicional: Se preço for fornecido no UPDATE, deve ser > 0
    @AssertTrue(groups = ValidationGroups.OnUpdate.class, 
                message = "Preço deve ser maior que zero quando fornecido")
    public boolean isPriceValidIfPresent() {
        return price == null || price.compareTo(BigDecimal.ZERO) > 0;
    }
    
    // Validação condicional: Se nome for fornecido no UPDATE, não pode ser vazio
    @AssertTrue(groups = ValidationGroups.OnUpdate.class,
                message = "Nome não pode ser vazio quando fornecido")
    public boolean isNameValidIfPresent() {
        return name == null || !name.isBlank();
    }
    
    // Validação condicional: Se SKU for fornecido no UPDATE, não pode ser vazio
    @AssertTrue(groups = ValidationGroups.OnUpdate.class,
                message = "SKU não pode ser vazio quando fornecido")
    public boolean isSkuValidIfPresent() {
        return sku == null || !sku.isBlank();
    }
}