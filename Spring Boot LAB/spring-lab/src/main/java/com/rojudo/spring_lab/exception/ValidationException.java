package com.rojudo.spring_lab.exception;

/* EXCEÇÃO DE VALIDAÇÃO DE PARÂMETROS
 * 
 * Utilizada para erros de validação de parâmetros de requisição
 * (ex: @RequestParam, @PathVariable)
 * 
 * HTTP Status: 400 Bad Request
 */
public class ValidationException extends RuntimeException {
    
    private final String field;
    private final String rejectedValue;
    
    public ValidationException(String message) {
        super(message);
        this.field = null;
        this.rejectedValue = null;
    }
    
    public ValidationException(String field, String rejectedValue, String message) {
        super(message);
        this.field = field;
        this.rejectedValue = rejectedValue;
    }
    
    public String getField() {
        return field;
    }
    
    public String getRejectedValue() {
        return rejectedValue;
    }
}