package com.rojudo.spring_lab.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CATEGORY ENTITY
 * 
 * Representa categorias de produtos com suporte a hierarquia (auto-relacionamento)
 * 
 * ESTRUTURA:
 * - Eletrônicos (parent = null)
 *   └── Computadores (parent = Eletrônicos)
 *       └── Notebooks (parent = Computadores)
 * 
 * ANOTAÇÕES JPA:
 * @Entity → Mapeia para tabela no banco
 * @Table → Configurações da tabela (nome, índices, constraints)
 * @ManyToOne → Relacionamento com categoria pai
 * @OneToMany → Relacionamento com categorias filhas
 */
@Entity
@Table(name = "categories", 
       indexes = {
           @Index(name = "idx_categories_name", columnList = "name"),
           @Index(name = "idx_categories_parent", columnList = "parent_id"),
           @Index(name = "idx_categories_active", columnList = "active")
       })
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    
    @Column(length = 500)
    private String description;
    
    /**
     * AUTO-RELACIONAMENTO PARA HIERARQUIA
     * 
     * @ManyToOne → Muitas categorias podem ter o mesmo pai
     * parent_id → Chave estrangeira para a própria tabela
     * 
     * Exemplo: "Notebooks" tem parent = "Computadores"
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;
    
    /**
     * LISTA DE SUB-CATEGORIAS
     * 
     * mappedBy = "parent" → Campo na classe filha que mapeia o relacionamento
     * cascade = ALL → Operaçoes em cascata (persist, merge, remove, refresh)
     * orphanRemoval = true → Remove filhas se removidas da lista
     */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // ===== CONSTRUTORES =====
    
    protected Category() {} // JPA requer construtor padrão
    
    public Category(String name) {
        this.name = name;
    }
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Category(String name, String description, Category parent) {
        this.name = name;
        this.description = description;
        this.parent = parent;
    }

    // ===== MÉTODOS DE NEGÓCIO =====
    
    /**
     * Adiciona uma sub-categoria
     * Mantém consistência bidirecional do relacionamento
     */
    public void addChild(Category child) {
        children.add(child);
        child.setParent(this);
    }
    
    /**
     * Remove uma sub-categoria
     */
    public void removeChild(Category child) {
        children.remove(child);
        child.setParent(null);
    }
    
    /**
     * Verifica se é uma categoria raiz (não tem pai)
     */
    public boolean isRoot() {
        return parent == null;
    }
    
    /**
     * Obtém o nível na hierarquia (0 = raiz)
     */
    public int getLevel() {
        int level = 0;
        Category current = this;
        while (current.getParent() != null) {
            level++;
            current = current.getParent();
        }
        return level;
    }
    
    /**
     * Obtém o caminho completo da categoria
     * Exemplo: "Eletrônicos > Computadores > Notebooks"
     */
    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        return parent.getFullPath() + " > " + name;
    }
    
    public void activate() {
        this.active = true;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    // ===== LIFECYCLE CALLBACKS =====
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // ===== GETTERS E SETTERS =====
    
    public Long getId() {
        return id;
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
    
    public Category getParent() {
        return parent;
    }
    
    public void setParent(Category parent) {
        this.parent = parent;
    }
    
    public List<Category> getChildren() {
        return children;
    }
    
    public void setChildren(List<Category> children) {
        this.children = children;
    }
    
    public Boolean getActive() {
        return active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    // ===== equals/hashCode =====
    // Baseado no ID para entidades JPA
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return id != null && Objects.equals(id, category.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}