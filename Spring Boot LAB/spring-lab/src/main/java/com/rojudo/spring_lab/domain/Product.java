package com.rojudo.spring_lab.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Index;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
        @UniqueConstraint(name = "uk_products_sku", columnNames = "sku")
    },
    indexes = {
        @Index(name = "idx_products_name", columnList = "name"),
        @Index(name = "idx_products_price", columnList = "price"),
        @Index(name = "idx_products_active", columnList = "active")
    }
)

/*
  HIBERNATE AVANÇADO:
  
  @DynamicUpdate  -> Atualiza apenas campos alterados (melhora performance)
  @DynamicInsert  -> Insere apenas campos não nulos
*/
@DynamicUpdate
@DynamicInsert

/*
  CACHE:
  - Segundo nível (Hibernate)
  - READ_WRITE garante consistência
*/
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "products")

/*
  SOFT DELETE:
  - Filtra automaticamente registros ativos
*/
@SQLRestriction("active = true")
@Where(clause = "active = true")

/*
  AUDITORIA AUTOMÁTICA (Spring Data)
*/
@EntityListeners(AuditingEntityListener.class)
public class Product {

    /*
      ID - Identificador único da entidade
      
      ESTRATÉGIAS:
      - IDENTITY (usado aqui): auto-increment (PostgreSQL)
      - SEQUENCE: melhor para batch
      - UUID: distribuído
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
      Campos obrigatórios
      
      - unique = true → constraint no banco
      - nullable = false → NOT NULL
     */
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    /*
      BigDecimal para valores monetários!
      
      POR QUE NÃO double/float?
      - Problemas de precisão
      - BigDecimal é imutável
      - Padrão financeiro
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
      Relacionamento Many-to-One com Category
      @ManyToOne → Muitos produtos podem pertencer a uma categoria
      @JoinColumn → Define a chave estrangeira (category_id)
      fetch = FetchType.LAZY → Carregamento preguiçoso (performance)
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "stock_quantity")
    private Integer stockQuantity = 0;

    /*
      SOFT DELETE FLAG
     */
    @Column(nullable = false)
    private Boolean active = true;

    // ============================================
    // POSTGRESQL FEATURES (AVANÇADO)
    // ============================================

    /*
      JSONB (PostgreSQL)
      - Estrutura flexível
      - Alta performance para leitura
     */
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", columnDefinition = "jsonb")
    private Map<String, Object> metadata;

    /*
      ARRAY PostgreSQL
     */
    @Type(StringArrayType.class)
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "tags", columnDefinition = "text[]")
    private String[] tags;

    /*
      FULL-TEXT SEARCH (PostgreSQL)
     
    @Column(name = "search_vector", columnDefinition = "tsvector")
    private String searchVector;*/

    // ============================================
    // AUDITORIA
    // ============================================

    /*
      Auditoria automática com Spring
      
      @CreatedDate / @LastModifiedDate
      - Gerenciados automaticamente
      
      @CreatedBy / @LastModifiedBy
      - Requer configuração de AuditorAware
     */
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    /*
      CONTROLE DE CONCORRÊNCIA
      
      @Version:
      - Evita sobrescrita concorrente
      - Optimistic locking
     */
    @Version
    private Long version;

    // ============================================
    // CONSTRUTORES
    // ============================================

    /*
      Construtor padrão (obrigatório para JPA)
     */
    protected Product() {}

    /*
      Construtor mínimo válido
     */
    public Product(String sku, String name, BigDecimal price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    // ============================================
    // MÉTODOS DE NEGÓCIO (DOMAIN LOGIC)
    // ============================================
    /*
      Regra de estoque
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

    // ============================================
    // LIFECYCLE CALLBACKS (JPA HOOKS)
    // ============================================

    /*
      @PrePersist → antes de inserir
      @PreUpdate → antes de atualizar
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();

        if (this.stockQuantity == null) this.stockQuantity = 0;
        if (this.active == null) this.active = true;

        updateSearchVector();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        updateSearchVector();
    }

    /*
      FULL-TEXT SEARCH PREPARATION
     */
    private void updateSearchVector() {
        /*this.searchVector = String.format(
            "%s %s %s",
            this.name,
            this.description != null ? this.description : "",
            this.category != null ? this.category : ""
        );*/
    }

    // ============================================
    // GETTERS / SETTERS
    // ============================================

    public Long getId() { return id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    public String[] getTags() { return tags; }
    public void setTags(String[] tags) { this.tags = tags; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public Long getVersion() { return version; }

    // ============================================
    // EQUALS / HASHCODE
    // ============================================

    /*
      Baseado em ID (JPA best practice)
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

    // ============================================
    // DEBUG
    // ============================================

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