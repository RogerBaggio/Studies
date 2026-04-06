package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * PERMISSION ENTITY - Permissões granulares
 * 
 * Exemplos: 
 * - PRODUCT_CREATE
 * - PRODUCT_READ
 * - PRODUCT_UPDATE
 * - PRODUCT_DELETE
 * - USER_MANAGE
 */
@Entity
@Table(name = "permissions")
public class Permission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String name;  // Ex: PRODUCT_CREATE
    
    @Column(length = 200)
    private String description;
    
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();

    // ===== CONSTRUTORES =====

    protected Permission() {} // JPA constructor
    
    public Permission(String name) {
        this.name = name;
    }
    
    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    public void addRole(Role role) { this.roles.add(role); role.getPermissions().add(this); }
    public void removeRole(Role role) { this.roles.remove(role); role.getPermissions().remove(this);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission that)) return false;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}