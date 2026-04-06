package com.rojudo.spring_lab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueSkuValidator.class)
@Documented
public @interface UniqueSku {
    
    String message() default "{product.sku.unique}";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    /**
     * Se true, ignora o ID atual (para UPDATE)
     */
    long ignoreId() default 0;
}