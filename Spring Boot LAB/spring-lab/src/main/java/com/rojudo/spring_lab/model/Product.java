package com.rojudo.spring_lab.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/*
  ENTITY: Representa a tabela no banco de dados
  
  POR QUE USAR ENTITY?
  - Mapeamento objeto-relacional (ORM)
  - Ciclo de vida gerenciado pelo EntityManager
  - Identidade rastreável (ID)
  - Pode ter comportamento de negócio
  
  PRINCÍPIOS:
  - POJO (Plain Old Java Object)
  - Anotações JPA para mapeamento
  - Encapsulamento com getters/setters
  - equals/hashCode baseado em ID
*/
@Entity
@Table(
    name = "products",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_products_sku",
            columnNames = "sku"
        )
    },
    indexes = {
        @Index(name = "idx_products_name", columnList = "name"),
        @Index(name = "idx_products_category", columnList = "category")
    }
)
public class Product {
    
    /*
      ID - Identificador único da entidade
      
      ESTRATÉGIAS DE GERAÇÃO:
      - IDENTITY: Auto-increment (MySQL, PostgreSQL)
      - SEQUENCE: Mais performático para batch inserts
      - UUID: Bom para sistemas distribuídos
      - TABLE: Portável mas menos performático
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /*
      Campos obrigatórios com constraints
      
      columnDefinition = "TEXT" - Tipo específico do banco
      nullable = false - NOT NULL constraint
      unique = true - UNIQUE constraint
     */
    @Column(name = "sku", nullable = false, unique = true, length = 50)
    private String sku;
    
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    /*
      BigDecimal para valores monetários!
      
      POR QUE NÃO double/float?
      - Problemas de precisão com números decimais
      - BigDecimal é imutável e preciso
      - Padrão bancário/financeiro
     */
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
    
    @Column(name = "category", length = 100)
    private String category;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity = 0;
    
    /*
      Campos de auditoria - rastreamento
      
      @CreationTimestamp e @UpdateTimestamp
      - Gerenciados automaticamente pelo Hibernate
      - Úteis para auditoria e debugging
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "active")
    private Boolean active = true;
    
    /*
      Construtor padrão (obrigatório para JPA)
      
      JPA precisa criar objetos via reflexão
      Deve ser protected ou public
     */
    protected Product() {
    }
    
    /*
      Construtor com parâmetros essenciais
     
      Design: Fornecer apenas o mínimo necessário
      Facilita criação de objetos válidos
     */
    public Product(String sku, String name, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
    
    // Métodos de negócio (comportamento)
    
    /*
      Métodos de domínio - Encapsulam regras de negócio
      
      POR QUE NÃO fazer isso no Service?
      - Coesão: comportamento pertence à entidade
      - Reuso: mesma regra em qualquer lugar
      - Testabilidade: testa comportamento isolado
     */
    public void updateStock(int quantity) {
        if (this.stockQuantity + quantity < 0) {
            throw new IllegalStateException(
                "Estoque insuficiente. Disponível: " + this.stockQuantity
            );
        }
        this.stockQuantity += quantity;
    }
    
    public boolean isAvailable() {
        return this.active && this.stockQuantity > 0;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    public void activate() {
        this.active = true;
    }
    
    public void updatePrice(BigDecimal newPrice) {
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        this.price = newPrice;
    }
    
    // Lifecycle callbacks - JPA hooks
    
    /*
      @PrePersist: Antes de inserir no banco
      @PreUpdate: Antes de atualizar no banco
      
      Útil para:
      - Auditoria automática
      - Validações antes da persistência
      - Cálculos derivados
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.stockQuantity == null) {
            this.stockQuantity = 0;
        }
        if (this.active == null) {
            this.active = true;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }
    
    public String getSku() {
        return sku;
    }
    
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    // equals/hashCode baseado em ID para entidades JPA
    
    /*
      POR QUE equals/hashCode baseado em ID?
      - Entidades JPA são comparadas por identidade
      - Evita problemas em coleções (Set, Map)
      - Consistência com banco de dados
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id != null && Objects.equals(id, product.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}