package com.rojudo.spring_lab.exception;

/*
  EXCEPTION PERSONALIZADA
  
  POR QUE?
  - Semântica específica do domínio
  - Tratamento diferenciado por tipo
  - Facilita logging e monitoramento
 */
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}