package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.mapper.ProductMapper;
import com.rojudo.spring_lab.dto.request.ProductRequest;
import com.rojudo.spring_lab.dto.response.ProductResponse;
import com.rojudo.spring_lab.domain.Category;
import com.rojudo.spring_lab.domain.Product;
import com.rojudo.spring_lab.repository.CategoryRepository;
import com.rojudo.spring_lab.repository.ProductRepository;
import com.rojudo.spring_lab.exception.ResourceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/*
  SERVICE: Camada de negócio
  
  POR QUE SERVICE?
  - Lógica de negócio complexa
  - Orquestração de múltiplos repositórios
  - Controle transacional
  - Regras de validação de negócio
  
  PRINCÍPIOS:
  - @Service indica componente de negócio
  - @Transactional gerencia transações
  - Singleton (uma instância por aplicação)
  - Coesão (operações relacionadas)
 */
@Service
@Transactional(readOnly = true) // Leitura por padrão, transações de escrita sobrescrevem
public class ProductService {
    
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    /*
      Injeção por construtor
      
      POR QUE?
     - Imutabilidade (final fields)
      - Testabilidade (mock fácil)
      - Dependências explícitas
     */
    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }
    
    /*
      CREATE - Cria um novo produto
      
      REGRAS DE NEGÓCIO:
      1. SKU deve ser único
      2. Produto é criado ativo por padrão
      3. Categoria deve existir se fornecida
      4. Validação de regras de negócio
     */
    @Transactional // Sobrescreve readOnly = true
    public ProductResponse create(ProductRequest request) {
        log.info("Creating new product with SKU: {}", request.sku());
        
        // 1. Validação de negócio: SKU único
        if (productRepository.existsBySku(request.sku())) {
            log.warn("Attempt to create product with existing SKU: {}", request.sku());
            throw new IllegalArgumentException("Produto com SKU " + request.sku() + " já existe");
        }
        
        // 2. Validação de negócio: Verificar se a categoria existe (se fornecida)
        Category category = null;
        if (request.category() != null && !request.category().isBlank()) {
            category = categoryRepository.findByName(request.category())
                .orElseThrow(() -> {
                    log.warn("Category not found: {}", request.category());
                    return new IllegalArgumentException("Categoria não encontrada: " + request.category());
                });
            log.debug("Category found: {} (ID: {})", category.getName(), category.getId());
        }
        
        // 3. Converter DTO para Entity
        Product product = productMapper.toEntity(request);
        
        // 4. Se a categoria foi validada, associar ao produto
        if (category != null) {
            product.setCategory(category);
        }
        
        // 5. Regras de negócio adicionais
        if (product.getStockQuantity() == null) {
            product.setStockQuantity(0);
        }
        
        // 6. Persistir
        Product savedProduct = productRepository.save(product);
        log.info("Product created successfully with ID: {}", savedProduct.getId());
        
        // 7. Converter para Response DTO
        return productMapper.toResponse(savedProduct);
    }
    
    // READ - Busca todos produtos (paginado)
    public Page<ProductResponse> findAll(Pageable pageable) {
        log.debug("Finding all products - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return productRepository.findAll(pageable)
            .map(productMapper::toResponse);
    }
    
    // READ - Busca produtos ativos (paginado)
    public Page<ProductResponse> findActiveProducts(Pageable pageable) {
        log.debug("Finding active products - Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
        return productRepository.findByActiveTrue(pageable)
            .map(productMapper::toResponse);
    }
    
    /*
      READ - Busca por ID
      
      @throws ResourceNotFoundException se não encontrar
     */
    public ProductResponse findById(Long id) {
        log.debug("Finding product by ID: {}", id);
        Product product = findProductEntityById(id);
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por SKU 
    public ProductResponse findBySku(String sku) {
        log.debug("Finding product by SKU: {}", sku);
        Product product = productRepository.findBySku(sku)
            .orElseThrow(() -> {
                log.warn("Product not found with SKU: {}", sku);
                return new ResourceNotFoundException("Produto com SKU " + sku + " não encontrado");
            });
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por nome (case insensitive)
    public List<ProductResponse> findByName(String name) {
        log.debug("Finding products by name containing: {}", name);
        return productRepository.findByNameContainingIgnoreCase(name)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // READ - Busca por faixa de preço
    public List<ProductResponse> findByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        log.debug("Finding products by price range: {} - {}", minPrice, maxPrice);
        
        // Validação de negócio
        if (minPrice.compareTo(maxPrice) > 0) {
            log.warn("Invalid price range: minPrice > maxPrice ({} > {})", minPrice, maxPrice);
            throw new IllegalArgumentException("Preço mínimo não pode ser maior que máximo");
        }
        
        return productRepository.findByPriceBetween(minPrice, maxPrice)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // UPDATE - Atualiza produto completo
    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        log.info("Updating product with ID: {}", id);
        
        // 1. Verificar se produto existe
        Product product = findProductEntityById(id);
        
        // 2. Se SKU mudou, verificar conflito
        if (request.sku() != null && !product.getSku().equals(request.sku())) {
            if (productRepository.existsBySku(request.sku())) {
                log.warn("Attempt to update product with existing SKU: {}", request.sku());
                throw new IllegalArgumentException("SKU " + request.sku() + " já está em uso");
            }
            product.setSku(request.sku());
            log.debug("SKU updated from {} to {}", product.getSku(), request.sku());
        }
        
        // 3. Validar categoria se fornecida
        if (request.category() != null) {
            if (request.category().isBlank()) {
                product.setCategory(null);
                log.debug("Category removed from product ID: {}", id);
            } else {
                Category category = categoryRepository.findByName(request.category())
                    .orElseThrow(() -> {
                        log.warn("Category not found for update: {}", request.category());
                        return new IllegalArgumentException("Categoria não encontrada: " + request.category());
                    });
                product.setCategory(category);
                log.debug("Category updated to: {}", category.getName());
            }
        }
        
        // 4. Atualizar outros campos
        productMapper.updateEntity(product, request);
        
        // 5. Persistir (JPA faz merge automático dentro da transação)
        Product updatedProduct = productRepository.save(product);
        log.info("Product updated successfully with ID: {}", updatedProduct.getId());
        
        // 6. Retornar resposta
        return productMapper.toResponse(updatedProduct);
    }
    
    /*
      DELETE - Remove produto (soft delete)
      
      POR QUE SOFT DELETE?
      - Manter histórico
      - Evitar perda de dados
      - Referências de integridade
     */
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting product with ID: {}", id);
        Product product = findProductEntityById(id);
        product.deactivate(); // Método de domínio
        productRepository.save(product);
        log.info("Product deactivated successfully: {}", id);
    }
    
    // DELETE - Remove produto (hard delete - uso controlado)
    @Transactional
    public void hardDelete(Long id) {
        log.warn("HARD DELETING product with ID: {}", id);
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
        }
        productRepository.deleteById(id);
        log.info("Product permanently deleted: {}", id);
    }
    
    /*
      BUSINESS OPERATION - Atualiza estoque
      
      Exemplo de operação de negócio complexa
     */
    @Transactional
    public void updateStock(Long id, int quantity) {
        log.info("Updating stock for product ID: {}, quantity change: {}", id, quantity);
        Product product = findProductEntityById(id);
        product.updateStock(quantity); // Método de domínio
        productRepository.save(product);
        log.info("Stock updated successfully. New stock: {}", product.getStockQuantity());
    }
    
    // BUSINESS OPERATION - Ativa/Desativa produto
    @Transactional
    public void toggleActive(Long id) {
        log.info("Toggling active status for product ID: {}", id);
        Product product = findProductEntityById(id);
        if (product.getActive()) {
            product.deactivate();
            log.info("Product deactivated: {}", id);
        } else {
            product.activate();
            log.info("Product activated: {}", id);
        }
        productRepository.save(product);
    }
    
    // BUSINESS OPERATION - Bulk price update
    @Transactional
    public int bulkPriceUpdate(String categoryName, BigDecimal percentage) {
        log.info("Bulk price update for category: {}, percentage: {}%", categoryName, percentage);
        
        // 1. Buscar a categoria pelo nome (converter String → Category)
        Category category = categoryRepository.findByName(categoryName)
            .orElseThrow(() -> {
                log.warn("Category not found for bulk update: {}", categoryName);
                return new IllegalArgumentException("Categoria não encontrada: " + categoryName);
            });
    
        // 2. Buscar produtos ativos da categoria
        List<Product> products = productRepository.findByActiveTrueAndCategory(category);
        
        if (products.isEmpty()) {
            log.info("No products found in category: {}", categoryName);
            return 0;  // Nenhum produto encontrado
        }
        
        log.info("Found {} products in category: {}", products.size(), categoryName);
    
        // 3. Aplicar novo preço
        for (Product product : products) {
            BigDecimal multiplier = BigDecimal.ONE.add(percentage.divide(new BigDecimal(100)));
            BigDecimal newPrice = product.getPrice().multiply(multiplier);
            BigDecimal oldPrice = product.getPrice();
            product.updatePrice(newPrice);
            log.debug("Product {} price updated: {} → {}", product.getSku(), oldPrice, newPrice);
        }
    
        // 4. Salvar todos
        productRepository.saveAll(products);
        log.info("Bulk price update completed. {} products updated.", products.size());
    
        return products.size();
    }
    
    /*
      Helper method - Busca entity ou lança exceção
      
      POR QUE?
      - Evitar duplicação de código
      - Tratamento consistente de "not found"
      - Útil para métodos que precisam da entity
     */
    private Product findProductEntityById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> {
                log.warn("Product not found with ID: {}", id);
                return new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
            });
    }
}