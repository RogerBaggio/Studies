package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.ProductRequestDTO;
import com.rojudo.spring_lab.dto.ProductResponseDTO;
import com.rojudo.spring_lab.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

/*
  CONTROLLER: Camada de apresentação (REST endpoints)
  
  POR QUE CONTROLLER?
  - Expor funcionalidades via HTTP
  - Validação de entrada
  - Mapeamento de status HTTP
  - Documentação da API
  
  PRINCÍPIOS:
  - @RestController = @Controller + @ResponseBody
  - @RequestMapping define base path
  - @Tag documenta no Swagger
 */
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Produtos", description = "API para gerenciamento de produtos")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    /*
      POST - Criar novo produto
      
      @ResponseStatus(201) - Created
      Location header com URI do recurso criado
     */
    @PostMapping
    @Operation(summary = "Criar novo produto", description = "Cria um produto com os dados fornecidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "409", description = "SKU já existe")
    })
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request) {
        ProductResponseDTO response = productService.create(request);
        
        // Padrão REST: retornar URI do recurso criado
        URI location = URI.create(String.format("/api/v1/products/%d", response.id()));
        
        return ResponseEntity.created(location).body(response);
    }
    
    /*
      GET - Listar todos produtos (paginado)
      
      @PageableDefault: Configuração padrão de paginação
     */
    @GetMapping
    @Operation(summary = "Listar produtos", description = "Retorna lista paginada de produtos")
    public ResponseEntity<Page<ProductResponseDTO>> findAll(
            @PageableDefault(
                size = 20,
                sort = "createdAt",
                direction = Sort.Direction.DESC
            ) Pageable pageable) {
        
        Page<ProductResponseDTO> products = productService.findAll(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    // GET - Produtos ativos (paginado)
    @GetMapping("/active")
    @Operation(summary = "Listar produtos ativos", description = "Retorna produtos ativos (com estoque > 0)")
    public ResponseEntity<Page<ProductResponseDTO>> findActiveProducts(
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<ProductResponseDTO> products = productService.findActiveProducts(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    // GET - Buscar por ID
    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProductResponseDTO> findById(
            @Parameter(description = "ID do produto", example = "1")
            @PathVariable Long id) {
        
        ProductResponseDTO product = productService.findById(id);
        
        return ResponseEntity.ok(product);
    }
    
    // GET - Buscar por SKU 
    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductResponseDTO> findBySku(@PathVariable String sku) {
        ProductResponseDTO product = productService.findBySku(sku);
        return ResponseEntity.ok(product);
    }
    
    // GET - Buscar por nome
    @GetMapping("/search")
    public ResponseEntity<List<ProductResponseDTO>> searchByName(
            @RequestParam String name) {
        
        List<ProductResponseDTO> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
    
    // GET - Buscar por faixa de preço
    @GetMapping("/price-range")
    public ResponseEntity<List<ProductResponseDTO>> findByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        
        List<ProductResponseDTO> products = productService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }
    
    // PUT - Atualizar produto (completo)
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {
        
        ProductResponseDTO response = productService.update(id, request);
        return ResponseEntity.ok(response);
    }
    
    // PATCH - Atualizar estoque (operação específica)
    @PatchMapping("/{id}/stock")
    @Operation(summary = "Atualizar estoque", description = "Adiciona ou remove unidades do estoque")
    public ResponseEntity<Void> updateStock(
            @PathVariable Long id,
            @RequestParam int quantity) {
        
        productService.updateStock(id, quantity);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    
    // PATCH - Ativar/desativar produto
    @PatchMapping("/{id}/toggle-active")
    public ResponseEntity<Void> toggleActive(@PathVariable Long id) {
        productService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }
    
    // PATCH - Atualização em lote (exemplo de operação complexa)
    @PatchMapping("/bulk/price-update")
    public ResponseEntity<Integer> bulkPriceUpdate(
            @RequestParam String category,
            @RequestParam BigDecimal percentage) {
        
        int updatedCount = productService.bulkPriceUpdate(category, percentage);
        return ResponseEntity.ok(updatedCount);
    }
    
    // DELETE - Soft delete (desativa)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Desativar produto", description = "Desativa o produto (soft delete)")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
    
    /**
      DELETE - Hard delete (uso restrito)
      
      Em produção, normalmente NÃO expor este endpoint
      Aqui apenas para demonstração
     */
    @DeleteMapping("/{id}/hard")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover permanentemente", description = "Remove o produto do banco de dados (uso restrito)")
    public void hardDelete(@PathVariable Long id) {
        productService.hardDelete(id);
    }
}