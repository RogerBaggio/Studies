package com.rojudo.spring_lab.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/*
  ESTRUTURA PADRÃO DE ERRO
  
  POR QUE?
  - Consistência nas respostas de erro
  - Facilita consumo pelo cliente
  - Inclui informações para debugging
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
    String type,           // Tipo do erro (Validation, Business, etc)
    String title,          // Título amigável
    int status,            // HTTP Status Code
    String detail,         // Detalhe específico
    String path,           // Path que gerou o erro
    LocalDateTime timestamp,
    Map<String, String> validationErrors, // Erros de validação de campos
    List<String> details   // Detalhes adicionais
) {
    public ErrorResponse(String type, String title, int status, String detail, String path) {
        this(type, title, status, detail, path, LocalDateTime.now(), null, null);
    }
    
    public ErrorResponse(String type, String title, int status, String detail, 
                         String path, Map<String, String> validationErrors) {
        this(type, title, status, detail, path, LocalDateTime.now(), validationErrors, null);
    }
}