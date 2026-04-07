package com.rojudo.spring_lab.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * LOGGING ASPECT
 * 
 * Log automático de métodos:
 * - Service: DEBUG (parâmetros + tempo)
 * - Controller: INFO (requisições)
 * - Repository: TRACE (queries)
 * 
 * USO DE TOKENS: Mínimo impacto (logs condicionais)
 */
@Aspect
@Component
public class LoggingAspect {
    
    // ===== SERVICE LAYER =====
    
    @Around("execution(* com.rojudo.spring_lab.service..*.*(..))")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        if (!log.isDebugEnabled()) {
            return joinPoint.proceed();
        }
        
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        log.debug("→ {}() - Args: {}", methodName, args);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        log.debug("← {}() - Return: {} - Time: {}ms", 
            methodName, result, stopWatch.getTotalTimeMillis());
        
        return result;
    }
    
    // ===== CONTROLLER LAYER =====
    
    @Around("execution(* com.rojudo.spring_lab.controller..*.*(..))")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        String methodName = joinPoint.getSignature().getName();
        
        log.info("→ {}", methodName);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        
        if (stopWatch.getTotalTimeMillis() > 1000) {
            log.warn("← {}() - SLOW ({}ms)", methodName, stopWatch.getTotalTimeMillis());
        } else {
            log.info("← {}() - {}ms", methodName, stopWatch.getTotalTimeMillis());
        }
        
        return result;
    }
    
    // ===== REPOSITORY LAYER (apenas se necessário) =====
    
    @Around("execution(* com.rojudo.spring_lab.repository..*.*(..))")
    public Object logRepository(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger log = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        
        if (!log.isTraceEnabled()) {
            return joinPoint.proceed();
        }
        
        String methodName = joinPoint.getSignature().getName();
        log.trace("→ {}", methodName);
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        Object result = joinPoint.proceed();
        
        stopWatch.stop();
        log.trace("← {} - {}ms", methodName, stopWatch.getTotalTimeMillis());
        
        return result;
    }
}