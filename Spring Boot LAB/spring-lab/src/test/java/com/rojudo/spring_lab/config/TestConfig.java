package com.rojudo.spring_lab.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.rojudo.spring_lab.validation.UniqueSkuValidator;

@TestConfiguration
public class TestConfig {

    @Bean
    @Primary  // Substitui o bean real nos testes
    public UniqueSkuValidator mockUniqueSkuValidator() {
        return new UniqueSkuValidator() {
            @Override
            public boolean isValid(String sku, jakarta.validation.ConstraintValidatorContext context) {
                return true;  // Sempre válido nos testes
            }
        };
    }
}