package com.rojudo.spring_lab.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/* ESTRUTURA PADRÃO DE ERRO
 * 
 * POR QUE?
 * - Consistência nas respostas de erro
 * - Facilita consumo pelo cliente
 * - Inclui informações para debugging
 * 
 * CAMPOS:
 * - traceId: Identificador único para rastreamento
 * - timestamp: Data/hora do erro (ISO format)
 * - status: HTTP Status Code
 * - error: Título amigável do erro
 * - message: Mensagem detalhada
 * - path: Endpoint que gerou o erro
 * - validationErrors: Erros de validação de campos (apenas para 400)
 * - details: Detalhes adicionais
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    String traceId,
    String timestamp,
    int status,
    String error,
    String message,
    String path,
    Map<String, String> validationErrors,
    List<String> details
) {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // Construtor para erros simples (sem validação)
    public ErrorResponse(String traceId, int status, String error, String message, String path) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, null, null);
    }
    
    // Construtor para erros de validação
    public ErrorResponse(String traceId, int status, String error, String message, 
                         String path, Map<String, String> validationErrors) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, validationErrors, null);
    }
    
    // Construtor para erros com detalhes adicionais
    public ErrorResponse(String traceId, int status, String error, String message, 
                         String path, List<String> details) {
        this(traceId, LocalDateTime.now().format(FORMATTER), status, error, message, path, null, details);
    }
}