package com.rojudo.spring_lab.service;

import com.rojudo.spring_lab.dto.ProductMapper;
import com.rojudo.spring_lab.dto.ProductRequestDTO;
import com.rojudo.spring_lab.dto.ProductResponseDTO;
import com.rojudo.spring_lab.model.Product;
import com.rojudo.spring_lab.repository.ProductRepository;
import com.rojudo.spring_lab.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    
    /*
      Injeção por construtor
      
      POR QUE?
     - Imutabilidade (final fields)
      - Testabilidade (mock fácil)
      - Dependências explícitas
     */
    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    
    /*
      CREATE - Cria um novo produto
      
      REGRAS DE NEGÓCIO:
      1. SKU deve ser único
      2. Produto é criado ativo por padrão
      3. Validação de regras de negócio
     */
    @Transactional // Sobrescreve readOnly = true
    public ProductResponseDTO create(ProductRequestDTO request) {
        // 1. Validação de negócio
        if (productRepository.existsBySku(request.sku())) {
            throw new IllegalArgumentException("Produto com SKU " + request.sku() + " já existe");
        }
        
        // 2. Converter DTO para Entity
        Product product = productMapper.toEntity(request);
        
        // 3. Regras de negócio adicionais
        if (product.getStockQuantity() == null) {
            product.setStockQuantity(0);
        }
        
        // 4. Persistir
        Product savedProduct = productRepository.save(product);
        
        // 5. Converter para Response DTO
        return productMapper.toResponse(savedProduct);
    }
    
    // READ - Busca todos produtos (paginado)
    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
            .map(productMapper::toResponse);
    }
    
    // READ - Busca produtos ativos (paginado)
    public Page<ProductResponseDTO> findActiveProducts(Pageable pageable) {
        return productRepository.findByActiveTrue(pageable)
            .map(productMapper::toResponse);
    }
    
    /*
      READ - Busca por ID
      
      @throws ResourceNotFoundException se não encontrar
     */
    public ProductResponseDTO findById(Long id) {
        Product product = findProductEntityById(id);
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por SKU 
    public ProductResponseDTO findBySku(String sku) {
        Product product = productRepository.findBySku(sku)
            .orElseThrow(() -> new ResourceNotFoundException("Produto com SKU " + sku + " não encontrado"));
        return productMapper.toResponse(product);
    }
    
    // READ - Busca por nome (case insensitive)
    public List<ProductResponseDTO> findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // READ - Busca por faixa de preço
    public List<ProductResponseDTO> findByPriceRange(java.math.BigDecimal minPrice, java.math.BigDecimal maxPrice) {
        // Validação de negócio
        if (minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("Preço mínimo não pode ser maior que máximo");
        }
        
        return productRepository.findByPriceBetween(minPrice, maxPrice)
            .stream()
            .map(productMapper::toResponse)
            .collect(Collectors.toList());
    }
    
    // UPDATE - Atualiza produto completo
    @Transactional
    public ProductResponseDTO update(Long id, ProductRequestDTO request) {
        // 1. Verificar se produto existe
        Product product = findProductEntityById(id);
        
        // 2. Se SKU mudou, verificar conflito
        if (!product.getSku().equals(request.sku())) {
            if (productRepository.existsBySku(request.sku())) {
                throw new IllegalArgumentException("SKU " + request.sku() + " já está em uso");
            }
            product.setSku(request.sku());
        }
        
        // 3. Atualizar campos
        productMapper.updateEntity(product, request);
        
        // 4. Persistir (JPA faz merge automático dentro da transação)
        Product updatedProduct = productRepository.save(product);
        
        // 5. Retornar resposta
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
        Product product = findProductEntityById(id);
        product.deactivate(); // Método de domínio
        productRepository.save(product);
    }
    
    // DELETE - Remove produto (hard delete - uso controlado)
    @Transactional
    public void hardDelete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto com ID " + id + " não encontrado");
        }
        productRepository.deleteById(id);
    }
    
    /*
      BUSINESS OPERATION - Atualiza estoque
      
      Exemplo de operação de negócio complexa
     */
    @Transactional
    public void updateStock(Long id, int quantity) {
        Product product = findProductEntityById(id);
        product.updateStock(quantity); // Método de domínio
        productRepository.save(product);
    }
    
    //BUSINESS OPERATION - Ativa/Desativa produto
    @Transactional
    public void toggleActive(Long id) {
        Product product = findProductEntityById(id);
        if (product.getActive()) {
            product.deactivate();
        } else {
            product.activate();
        }
        productRepository.save(product);
    }
    
    //BUSINESS OPERATION - Bulk price update
    @Transactional
    public int bulkPriceUpdate(String category, java.math.BigDecimal percentage) {
        // Busca produtos da categoria
        List<Product> products = productRepository.findByActiveTrueAndCategory(category);
        
        // Aplica novo preço
        for (Product product : products) {
            java.math.BigDecimal newPrice = product.getPrice()
                .multiply(java.math.BigDecimal.ONE.add(percentage.divide(new java.math.BigDecimal(100))));
            product.updatePrice(newPrice);
        }
        
        // Save all
        productRepository.saveAll(products);
        
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
            .orElseThrow(() -> new ResourceNotFoundException("Produto com ID " + id + " não encontrado"));
    }
}