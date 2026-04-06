package com.rojudo.spring_lab.repository;

import com.rojudo.spring_lab.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductRepositoryCustom {
    Page<Product> findAllWithSpecification(Specification<Product> spec, Pageable pageable);
}