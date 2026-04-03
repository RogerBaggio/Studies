package com.rojudo.spring_lab.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * USER ENTITY - Implementa UserDetails do Spring Security
 * 
 * PRINCÍPIOS:
 * - UserDetails: Interface do Spring Security para autenticação
 * - Separação: Entidade de domínio NÃO deve ter anotações de segurança
 *   Mas implementamos UserDetails para facilitar integração
 */
@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_email", columnNames = "email")
    },
    indexes = {
        @Index(name = "idx_users_email", columnList = "email"),
        @Index(name = "idx_users_active", columnList = "active")
    }
)
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String password;  // Será armazenada com BCrypt
    
    @Column(nullable = false, length = 100)
    private String fullName;
    
    @Column(length = 20)
    private String phone;
    
    @Column(nullable = false)
    private Boolean active = true;
    
    @Column(nullable = false)
    private Boolean emailVerified = false;
    
    // Mapeamento de roles (muitos-para-muitos)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    
    // Campos de auditoria
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    
    @Column(name = "failed_attempts")
    private Integer failedAttempts = 0;
    
    @Column(name = "account_locked")
    private Boolean accountLocked = false;
    
    @Column(name = "lock_expiry")
    private LocalDateTime lockExpiry;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // ===== CONSTRUTORES =====
    
    protected User() {}
    
    // Construtor público para criação
    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.active = true;
        this.emailVerified = false;
        this.failedAttempts = 0;
        this.accountLocked = false;
    }
    
    // Construtor sem parâmetros para uso interno
    public static User createNew() {
        return new User();
    }

    // ===== MÉTODOS DE NEGÓCIO =====
    
    public void incrementFailedAttempts() {
        this.failedAttempts++;
        if (this.failedAttempts >= 5) {
            this.accountLocked = true;
            this.lockExpiry = LocalDateTime.now().plusMinutes(30);
        }
    }
    
    public void resetFailedAttempts() {
        this.failedAttempts = 0;
        this.accountLocked = false;
        this.lockExpiry = null;
    }
    
    public void recordSuccessfulLogin() {
        this.lastLogin = LocalDateTime.now();
        this.resetFailedAttempts();
    }
    
    public boolean isAccountLocked() {
        if (accountLocked && lockExpiry != null && LocalDateTime.now().isAfter(lockExpiry)) {
            // Desbloqueia automaticamente após expiração
            this.accountLocked = false;
            this.lockExpiry = null;
            return false;
        }
        return accountLocked;
    }
    
    public void verifyEmail() {
        this.emailVerified = true;
    }
    
    // ===== USERDETAILS IMPLEMENTATION =====
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Converte roles para GrantedAuthority
        return roles.stream()
            .flatMap(role -> role.getPermissions().stream())
            .map(permission -> new SimpleGrantedAuthority(permission.getName()))
            .collect(Collectors.toSet());
    }
    
    @Override
    public String getPassword() {
        return this.password;
    }
    
    @Override
    public String getUsername() {
        return this.email;  // Usamos email como username
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return this.active && this.emailVerified;
    }
    
    // ===== LIFECYCLE CALLBACKS =====
    
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.failedAttempts == null) this.failedAttempts = 0;
        if (this.active == null) this.active = true;
        if (this.emailVerified == null) this.emailVerified = false;
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    
    // ===== GETTERS/SETTERS =====
    
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Boolean getEmailVerified() { return emailVerified; }
    public void setEmailVerified(Boolean emailVerified) { this.emailVerified = emailVerified; }
    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
    public Integer getFailedAttempts() { return failedAttempts; }
    public void setFailedAttempts(int failedAttempts) { this.failedAttempts = failedAttempts; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setAccountLocked(boolean accountLocked) { this.accountLocked = accountLocked; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && Objects.equals(id, user.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", active=" + active +
                '}';
    }
}