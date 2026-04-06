package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Page<Product> findAllWithSpecification(Specification<Product> spec, Pageable pageable) {
        var cb = entityManager.getCriteriaBuilder();
        var query = cb.createQuery(Product.class);
        var root = query.from(Product.class);
        
        var predicates = new ArrayList<Predicate>();
        if (spec != null) {
            predicates.add(spec.toPredicate(root, query, cb));
        }
        
        query.where(predicates.toArray(new Predicate[0]));
        
        var typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((int) pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());
        
        var products = typedQuery.getResultList();
        
        // Count query
        var countQuery = cb.createQuery(Long.class);
        var countRoot = countQuery.from(Product.class);
        countQuery.select(cb.count(countRoot));
        if (spec != null) {
            countQuery.where(spec.toPredicate(countRoot, countQuery, cb));
        }
        
        Long total = entityManager.createQuery(countQuery).getSingleResult();
        
        return new PageImpl<>(products, pageable, total);
    }
}