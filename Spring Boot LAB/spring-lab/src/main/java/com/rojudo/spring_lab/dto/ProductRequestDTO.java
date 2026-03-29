package com.rojudo.spring_lab.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

/*
  REQUEST DTO: Dados de entrada da API
  
  POR QUE USAR DTO?
  - Desacoplamento: API não expõe entidade diretamente
  - Validação específica para API
  - Versionamento: pode evoluir sem afetar entidade
  - Segurança: controla exatamente o que entra
  
  PRINCÍPIOS:
  - Imutabilidade (record)
  - Validações declarativas
  - Documentação automática
 */
public record ProductRequestDTO(
    
    @NotBlank(message = "SKU é obrigatório")
    @Size(min = 3, max = 50, message = "SKU deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Z0-9-]+$", message = "SKU deve conter apenas letras maiúsculas, números e hífen")
    String sku,
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 200, message = "Nome deve ter entre 3 e 200 caracteres")
    String name,
    
    @Size(max = 1000, message = "Descrição deve ter no máximo 1000 caracteres")
    String description,
    
    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço deve ser maior que zero")
    @DecimalMax(value = "999999.99", message = "Preço excede o limite permitido")
    BigDecimal price,
    
    @Size(max = 100, message = "Categoria deve ter no máximo 100 caracteres")
    String category,
    
    @Min(value = 0, message = "Quantidade em estoque não pode ser negativa")
    @Max(value = 999999, message = "Quantidade em estoque excede o limite")
    Integer stockQuantity
    
) {
    // Validação customizada entre campos
    public ProductRequestDTO {
        if (stockQuantity != null && price.compareTo(BigDecimal.ZERO) > 0) {
            // Lógica de validação cross-campos se necessário
        }
    }
}