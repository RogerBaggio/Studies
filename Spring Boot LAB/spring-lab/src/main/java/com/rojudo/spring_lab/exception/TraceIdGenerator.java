package com.rojudo.spring_lab.exception;

import org.springframework.stereotype.Component;

import java.util.UUID;

/* GERADOR DE TRACE ID 
   Responsável por gerar identificadores únicos para cada erro
   Útil para rastreamento em logs e debugging
 */
@Component
public class TraceIdGenerator {
    
    /* Gera um Trace ID único
       Formato: TIMESTAMP-UUID (ex: 20260406-123456-abc123def)
     */
    public static String generate() {
        return String.format("%s-%s", 
            java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")),
            UUID.randomUUID().toString().substring(0, 8)
        );
    }
    
    // Gera Trace ID para ser usado no MDC (Mapped Diagnostic Context) do SLF4J
    public static String generateForMdc() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}