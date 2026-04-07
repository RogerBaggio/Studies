package com.rojudo.spring_lab.exception;

/* EXCEÇÃO DE NEGÓCIO
 * 
 * Utilizada para erros de regras de negócio que NÃO são erros de validação de campos
 * Exemplos:
 * - Estoque insuficiente
 * - Produto já desativado
 * - Operação não permitida no estado atual
 * 
 * HTTP Status: 422 Unprocessable Entity
 */
public class BusinessException extends RuntimeException {
    
    private final String errorCode;
    
    public BusinessException(String message) {
        super(message);
        this.errorCode = "BUSINESS_ERROR";
    }
    
    public BusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "BUSINESS_ERROR";
    }
    
    public String getErrorCode() {
        return errorCode;
    }
}