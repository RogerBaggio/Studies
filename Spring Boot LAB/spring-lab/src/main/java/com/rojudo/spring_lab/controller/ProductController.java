package com.rojudo.spring_lab.controller;

import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.service.ProductService;
import com.rojudo.spring_lab.validation.ValidationGroups;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import jakarta.validation.constraints.Max;

/*CONTROLLER: Camada de apresentação (REST endpoints)
  
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
  
  VALIDAÇÃO POR GRUPOS:
  - @Validated(OnCreate.class): Usado para CREATE - valida todos os campos obrigatórios
  - @Validated(OnUpdate.class): Usado para UPDATE - SKU, nome e preço são opcionais
  - @Valid: Usado para operações específicas como PATCH /stock
  
  VALIDAÇÃO DE PARÂMETROS:
  - @Min, @Max, @Positive, @Size: Valida parâmetros de URL e query string
  - @Validated a nível de classe habilita estas validações
 */
@RestController
@RequestMapping("/api/v1/products")
@Validated  // Habilita validação de parâmetros (@RequestParam, @PathVariable)
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
    public ResponseEntity<Page<ProductResponse>> findAll(
            @PageableDefault(
                size = 20,
                sort = "createdAt",
                direction = Sort.Direction.DESC
            ) Pageable pageable) {
        
        Page<ProductResponse> products = productService.findAll(pageable);
        
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
    public ResponseEntity<Page<ProductResponse>> findActiveProducts(
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<ProductResponse> products = productService.findActiveProducts(pageable);
        
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por ID
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Acesso detalhado a um produto específico
      
      VALIDAÇÃO: ID deve ser maior que 0 (positivo)
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProductResponse> findById(
            @Parameter(description = "ID do produto", example = "1")
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") Long id) {
        
        ProductResponse product = productService.findById(id);
        
        return ResponseEntity.ok(product);
    }
    
    /*
      GET - Buscar por SKU
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca por SKU (identificador único do produto)
      
      VALIDAÇÃO: SKU deve ter entre 3 e 50 caracteres
     */
    @GetMapping("/sku/{sku}")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<ProductResponse> findBySku(
            @PathVariable @Size(min = 3, max = 50, message = "SKU deve ter entre 3 e 50 caracteres") 
            String sku) {
        
        ProductResponse product = productService.findBySku(sku);
        return ResponseEntity.ok(product);
    }
    
    /*
      GET - Buscar por nome
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Busca textual por nome do produto (case insensitive)
      
      VALIDAÇÃO: Nome deve ter entre 2 e 100 caracteres
     */
    @GetMapping("/search")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponse>> searchByName(
            @RequestParam @Size(min = 2, max = 100, message = "Nome para busca deve ter entre 2 e 100 caracteres") 
            String name) {
        
        List<ProductResponse> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
    
    /*
      GET - Buscar por faixa de preço
      
      SEGURANÇA: Requer permissão PRODUCT_READ
      - Filtro por intervalo de preços (minPrice e maxPrice)
      
      VALIDAÇÃO: 
      - minPrice deve ser maior que 0
      - maxPrice deve ser maior que 0
     */
    @GetMapping("/price-range")
    @PreAuthorize("hasAuthority('PRODUCT_READ')")
    public ResponseEntity<List<ProductResponse>> findByPriceRange(
            @RequestParam @Positive(message = "Preço mínimo deve ser maior que zero") 
            BigDecimal minPrice,
            @RequestParam @Positive(message = "Preço máximo deve ser maior que zero") 
            BigDecimal maxPrice) {
        
        List<ProductResponse> products = productService.findByPriceRange(minPrice, maxPrice);
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
      
      VALIDAÇÃO: Usa grupo OnCreate
      - SKU: obrigatório e único
      - Nome: obrigatório
      - Preço: obrigatório e > 0
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
    public ResponseEntity<ProductResponse> create(
            @Validated(ValidationGroups.OnCreate.class) 
            @RequestBody ProductRequest request) {
        
        ProductResponse response = productService.create(request);
        
        // Padrão REST: retornar URI do recurso criado
        URI location = URI.create(String.format("/api/v1/products/%d", response.id()));
        
        return ResponseEntity.created(location).body(response);
    }
    
    /*
      PUT - Atualizar produto (completo)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Apenas ADMIN e MANAGER podem atualizar produtos
      - Atualização completa (todos os campos)
      
      VALIDAÇÃO: Usa grupo OnUpdate
      - SKU: opcional, mas se fornecido deve ser único (ignorando o próprio ID)
      - Nome: opcional, mas se fornecido não pode ser vazio
      - Preço: opcional, mas se fornecido deve ser > 0
      
      VALIDAÇÃO DE PARÂMETRO: ID deve ser maior que 0
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<ProductResponse> update(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id,
            @Validated(ValidationGroups.OnUpdate.class) 
            @RequestBody ProductRequest request) {
        
        ProductResponse response = productService.update(id, request);
        return ResponseEntity.ok(response);
    }
    
    /*
      PATCH - Atualizar estoque (operação específica)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Operação específica para controle de estoque
      - Útil para sistemas de inventário
      
      VALIDAÇÃO: Usa @Valid (validação padrão, sem grupos especiais)
      - ID deve ser positivo
      - Quantidade pode ser positiva (adicionar) ou negativa (remover)
     */
    @PatchMapping("/{id}/stock")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    @Operation(summary = "Atualizar estoque", description = "Adiciona ou remove unidades do estoque")
    public ResponseEntity<Void> updateStock(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id,
            @RequestParam int quantity) {
        
        productService.updateStock(id, quantity);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    
    /*
      PATCH - Ativar/desativar produto
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Permite ativar ou desativar um produto (soft delete controlado)
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @PatchMapping("/{id}/toggle-active")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Void> toggleActive(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
        productService.toggleActive(id);
        return ResponseEntity.noContent().build();
    }
    
    /*
      PATCH - Atualização em lote (exemplo de operação complexa)
      
      SEGURANÇA: Requer permissão PRODUCT_UPDATE
      - Atualiza preços de todos produtos de uma categoria
      - Operação administrativa em lote
      
      VALIDAÇÃO: 
      - Categoria deve ter entre 3 e 100 caracteres
      - Percentual deve estar entre -100 e 1000 (evita valores absurdos)
     */
    @PatchMapping("/bulk/price-update")
    @PreAuthorize("hasAuthority('PRODUCT_UPDATE')")
    public ResponseEntity<Integer> bulkPriceUpdate(
            @RequestParam @Size(min = 3, max = 100, message = "Nome da categoria deve ter entre 3 e 100 caracteres") 
            String category,
            @RequestParam @Min(value = -100, message = "Percentual não pode ser menor que -100% (redução máxima)") 
                         @Max(value = 1000, message = "Percentual não pode ser maior que 1000% (aumento máximo)")
            BigDecimal percentage) {
        
        int updatedCount = productService.bulkPriceUpdate(category, percentage);
        return ResponseEntity.ok(updatedCount);
    }
    
    // ==================== ENDPOINTS DE EXCLUSÃO (DELETE) ====================
    
    /*
      DELETE - Soft delete (desativa)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE
      - Apenas ADMIN pode deletar produtos
      - Soft delete: apenas desativa, mantém histórico
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Desativar produto", description = "Desativa o produto (soft delete)")
    public void delete(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
        productService.delete(id);
    }
    
    /*
      DELETE - Hard delete (uso restrito)
      
      SEGURANÇA: Requer permissão PRODUCT_DELETE (nível ADMIN)
      - Em produção, normalmente NÃO expor este endpoint
      - Remove permanentemente do banco de dados
      - Use com EXTREMO CUIDADO!
      
      @PreAuthorize("hasRole('ADMIN')") - Restrição adicional por role
      
      VALIDAÇÃO: ID deve ser positivo
     */
    @DeleteMapping("/{id}/hard")
    @PreAuthorize("hasRole('ADMIN') and hasAuthority('PRODUCT_DELETE')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remover permanentemente", description = "Remove o produto do banco de dados (uso restrito - apenas ADMIN)")
    public void hardDelete(
            @PathVariable @Positive(message = "ID do produto deve ser um número positivo") 
            Long id) {
        
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
      
      VALIDAÇÃO: userId deve ser positivo
     */
    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.principal.id")
    @Operation(summary = "Produtos por usuário", description = "Retorna produtos associados a um usuário específico")
    public ResponseEntity<List<ProductResponse>> findProductsByUser(
            @PathVariable @Positive(message = "ID do usuário deve ser um número positivo") 
            Long userId) {
        
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
  
  VALIDAÇÃO POR GRUPOS:
  
  | Grupo | Uso | Campos validados |
  |-------|-----|------------------|
  | OnCreate | POST /products | SKU (obrigatório, único), Nome (obrigatório), Preço (obrigatório, >0) |
  | OnUpdate | PUT /products/{id} | SKU (opcional, único ignorando próprio ID), Nome (opcional), Preço (opcional, >0 se fornecido) |
  
  VALIDAÇÃO DE PARÂMETROS (NOVO):
  
  | Parâmetro | Validação | Endpoint |
  |-----------|-----------|----------|
  | id (path) | @Positive | /{id}, /{id}/stock, /{id}/toggle-active, etc. |
  | sku (path) | @Size(min=3, max=50) | /sku/{sku} |
  | name (query) | @Size(min=2, max=100) | /search |
  | minPrice, maxPrice (query) | @Positive | /price-range |
  | category (query) | @Size(min=3, max=100) | /bulk/price-update |
  | percentage (query) | @Min(-100), @Max(1000) | /bulk/price-update |
  | userId (path) | @Positive | /user/{userId} |
*/