package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.failedAttempts = 0, u.accountLocked = false WHERE u.email = :email")
    void resetFailedAttempts(String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.active = false WHERE u.id = :id")
    void softDelete(Long id);
}