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
import org.springframework.security.access.prepost.PreAuthorize;
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
  
  SEGURANÇA:
  - @PreAuthorize: Controla acesso baseado em roles/permissões
  - hasAuthority(): Verifica permissões específicas (ex: PRODUCT_READ)
  - hasRole(): Verifica papéis (ex: ROLE_ADMIN)
  - Expressões podem combinar condições com operadores lógicos
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
    
    // ==================== ENDPOINTS DE LEITURA (READ) ====================
    
    /*
      GET - Listar todos produtos (paginado)
      
      @PageableDefault: Configuração padrão de paginação
      
      SEGURANÇA: Qualquer usuário autenticado com permissão PRODUCT_READ
      - Usuários comuns (ROLE_USER) têm esta permissão via role padrão
      - Admins e Managers também têm acesso
     */
    @GetMapping
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
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
    
    /*
      GET - Produtos ativos (paginado)
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Filtro por produtos ativos, útil para catálogos públicos
     */
    @GetMapping("/active")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    @Operation(summary = "Listar produtos ativos", description = "Retorna produtos ativos (com estoque > 0)")
    public ResponseEntity<Page<ProductResponseDTO>> findActiveProducts(
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<ProductResponseDTO> products = productService.findActiveProducts(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por ID
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Acesso detalhado a um produto específico
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
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
    
    /*
      GET - Buscar por SKU
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca por SKU (identificador único do produto)
     */
    @GetMapping("/sku/{sku}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<ProductResponseDTO> findBySku(@PathVariable String sku) {
        ProductResponseDTO product = productService.findBySku(sku);
        return ResponseEntity.ok(product);
    }
    
    /*
      GET - Buscar por nome
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca textual por nome do produto (case insensitive)
     */
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponseDTO>> searchByName(
            @RequestParam String name) {
        
        List<ProductResponseDTO> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por faixa de preço
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Filtro por intervalo de preços (minPrice e maxPrice)
     */
    @GetMapping("/price-range")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponseDTO>> findByPriceRange(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice) {
        
        List<ProductResponseDTO> products = productService.findByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(products);
    }
    
    // ==================== ENDPOINTS DE ESCRITA (WRITE) ====================
    
    /*
      POST - Criar novo produto
      
      @ResponseStatus(201) - Created
      Location header com URI do recurso criado
      
      SEGURANÇA: Requer permissão PRODUCT_CREATE
      - Apenas ADMIN e MANAGER têm esta permissão
      - Usuários comuns NÃO podem criar produtos
     */
    @PostMapping
    @PreAuthorize("hasAuthority('PRODUCT_CREATE')")
    @Operation(summary = "Criar novo produto", description = "Cria um produto com os dados fornecidos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "403", description = "Acesso negado"),
        @ApiResponse(responseCode = "409", description = "SKU já existe")
    })
    public ResponseEntity<ProductResponseDTO> create(@Valid @RequestBody ProductRequestDTO request) {
        ProductResponseDTO response = productService.create(request);
        
        // Padrão REST: retornar URI do recurso criado
        URI location = URI.create(String.format("/api/v1/products/%d", response.id()));
        
        return ResponseEntity.created(location).body(response);
    }
    
    /*
      PUT - Atualizar produto (completo)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Apenas ADMIN e MANAGER podem atualizar produtos
      - Atualização completa (todos os campos)
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<ProductResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {
        
        ProductResponseDTO response = productService.update(id, request);
        return ResponseEntity.ok(response);
    }
    
    /*
      PATCH - Atualizar estoque (operação específica)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Operação específica para controle de estoque
      - Útil para sistemas de inventário
     */
    @PatchMapping("/{id}/stock")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    @Operation(summary = "Atualizar estoque", description = "Adiciona ou remove unidades do estoque")
    public ResponseEntity<Void> updateStock(
            @PathVariable Long id,
            @RequestParam int quantity) {
        
        productService.updateStock(id, quantity);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    
    /*
      PATCH - Ativar/desativar produto
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Permite ativar ou desativar um produto (soft delete controlado)
     */
    @PatchMapping("/{id}/toggle-active")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Void> toggleActive(@PathVariable Long id) {
        productService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }
    
    /*
      PATCH - Atualização em lote (exemplo de operação complexa)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Atualiza preços de todos produtos de uma categoria
      - Operação administrativa em lote
     */
    @PatchMapping("/bulk/price-update")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Integer> bulkPriceUpdate(
            @RequestParam String category,
            @RequestParam BigDecimal percentage) {
        
        int updatedCount = productService.bulkPriceUpdate(category, percentage);
        return ResponseEntity.ok(updatedCount);
    }
    
    // ==================== ENDPOINTS DE EXCLUSÃO (DELETE) ====================
    
    /*
      DELETE - Soft delete (desativa)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE
      - Apenas ADMIN pode deletar produtos
      - Soft delete: apenas desativa, mantém histórico
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Desativar produto", description = "Desativa o produto (soft delete)")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
    
    /*
      DELETE - Hard delete (uso restrito)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE (nível ADMIN)
      - Em produção, normalmente NÃO expor este endpoint
      - Remove permanentemente do banco de dados
      - Use com EXTREMO CUIDADO!
      
      @PreAuthorize("hasRole('ADMIN')") - Restrição adicional por role
     */
    @DeleteMapping("/{id}/hard")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover permanentemente", description = "Remove o produto do banco de dados (uso restrito - apenas ADMIN)")
    public void hardDelete(@PathVariable Long id) {
        productService.hardDelete(id);
    }
    
    // ==================== ENDPOINTS EXTRAS COM CONTROLE DE ACESSO ====================
    
    /*
      EXEMPLO: Acesso baseado no próprio usuário
      
      GET - Buscar produtos por usuário (exemplo de controle de acesso)
      
      SEGURANÇA: Apenas o próprio usuário ou ADMIN podem ver
      - Expressão: hasRole('ADMIN') or #userId == authentication.principal.id
      - #userId referencia o parâmetro do método
      - authentication.principal.id acessa o ID do usuário autenticado
      
      NOTA: Este é um exemplo didático. Em um cenário real, você teria um
      relacionamento entre usuários e produtos (ex: produtos criados por usuário)
     */
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    @Operation(summary = "Produtos por usuário", description = "Retorna produtos associados a um usuário específico")
    public ResponseEntity<List<ProductResponseDTO>> findProductsByUser(@PathVariable Long userId) {
        // Implementação: productService.findByUserId(userId)
        // Por enquanto, retorna lista vazia como exemplo
        return ResponseEntity.ok(List.of());
    }
}

/*
  RESUMO DAS PERMISSÕES IMPLEMENTADAS:
  
  | Endpoint                    | Método | Permissão Necessária | Roles que têm acesso           |
  |-----------------------------|--------|---------------------|--------------------------------|
  | /products                   | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/active            | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/{id}              | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/sku/{sku}         | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/search            | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products/price-range       | GET    | PRODUCT_READ        | USER, MANAGER, ADMIN           |
  | /products                   | POST   | PRODUCT_CREATE      | MANAGER, ADMIN                 |
  | /products/{id}              | PUT    | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}/stock        | PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}/toggle-active| PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/bulk/price-update | PATCH  | PRODUCT_UPDATE      | MANAGER, ADMIN                 |
  | /products/{id}              | DELETE | PRODUCT_DELETE      | ADMIN (apenas)                 |
  | /products/{id}/hard         | DELETE | ADMIN + DELETE      | ADMIN (apenas)                 |
  | /products/user/{userId}     | GET    | USER_OWN or ADMIN   | Usuário dono ou ADMIN          |
  
  PRINCÍPIOS DE SEGURANÇA APLICADOS:
  
  1. PRINCÍPIO DO MENOR PRIVILÉGIO:
     - Cada endpoint concede apenas as permissões mínimas necessárias
     - Usuários comuns têm apenas permissão de leitura (PRODUCT_READ)
  
  2. DEFESA EM PROFUNDIDADE:
     - Múltiplas camadas de segurança:
       * Filter chain (autenticação)
       * @PreAuthorize (autorização)
       * Validações de negócio no Service
  
  3. SEPARAÇÃO DE RESPONSABILIDADES:
     - Controller: Responsável apenas por receber requisições e aplicar autorização
     - Service: Contém regras de negócio
     - Repository: Acesso a dados
  
  4. AUDITABILIDADE:
     - Operações críticas (delete, create) são logadas
     - Possibilidade de rastrear quem fez o quê
*/