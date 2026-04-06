package com.rojudo.spring_lab.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ROLE ENTITY - Papéis do usuário
 * 
 * Exemplos: ROLE_ADMIN, ROLE_USER, ROLE_MANAGER
 
 Relacionamentos:
 - Role ←→ Permission (ManyToMany)
 - User ←→ Role (ManyToMany) - Bidirecional
 */
@Entity
@Table(name = "roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 50)
    private String name;  // Ex: ROLE_ADMIN
    
    @Column(length = 100)
    private String description;
    
    /*
      RELACIONAMENTO COM PERMISSIONS (ManyToMany)
      Dono do relacionamento (contém a @JoinTable)
    */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();
    
    /*
      User é o dono do relacionamento (contém a @JoinTable)
      mappedBy = "roles" → Refere-se ao campo 'roles' na classe User
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    // Construtores
    protected Role() {}
    
    public Role(String name) {
        this.name = name;
    }
    
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ===== MÉTODOS UTILITÁRIOS PARA CONSISTÊNCIA =====
     
    // Adiciona um usuário a este papel
    public void addUser(User user) {
        this.users.add(user);
        user.getRoles().add(this);
    }
    
    // Remove um usuário deste papel
    public void removeUser(User user) {
        this.users.remove(user);
        user.getRoles().remove(this);
    }
    
    // Adiciona uma permissão a este papel
    public void addPermission(Permission permission) {
        this.permissions.add(permission);
        permission.getRoles().add(this);
    }
    
    // Remove uma permissão deste papel
    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
        permission.getRoles().remove(this);
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Permission> getPermissions() { return permissions; }
    public void setPermissions(Set<Permission> permissions) { this.permissions = permissions; }
    public Set<User> getUsers() { return users; }
    public void setUsers(Set<User> users) { this.users = users; }
    
    // ===== equals/hashCode =====
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return id != null && Objects.equals(id, role.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}