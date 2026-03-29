package com.rojudo.spring_lab.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
  GLOBAL EXCEPTION HANDLER
  
  POR QUE?
  - Tratamento centralizado de exceções
  - Respostas consistentes
  - Separa tratamento de erro da lógica de negócio
  
  @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    // 400 - Validation errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        ErrorResponse response = new ErrorResponse(
            "ValidationError",
            "Erro de validação",
            HttpStatus.BAD_REQUEST.value(),
            "Os dados fornecidos são inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // 400 - Constraint violation (@Validated em parâmetros)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {
        
        Map<String, String> errors = ex.getConstraintViolations().stream()
            .collect(Collectors.toMap(
                violation -> violation.getPropertyPath().toString(),
                ConstraintViolation::getMessage,
                (v1, v2) -> v1 // Em caso de conflito, mantém o primeiro
            ));
        
        ErrorResponse response = new ErrorResponse(
            "ValidationError",
            "Erro de validação",
            HttpStatus.BAD_REQUEST.value(),
            "Dados inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // 400 - Type mismatch (ex: String ao invés de Long)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {
        
        String message = String.format(
            "Parâmetro '%s' deve ser do tipo %s",
            ex.getName(),
            ex.getRequiredType().getSimpleName()
        );
        
        ErrorResponse response = new ErrorResponse(
            "TypeMismatch",
            "Erro de tipo",
            HttpStatus.BAD_REQUEST.value(),
            message,
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // 400 - JSON malformado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMalformedJson(
            HttpMessageNotReadableException ex,
            HttpServletRequest request) {
        
        ErrorResponse response = new ErrorResponse(
            "MalformedJson",
            "JSON inválido",
            HttpStatus.BAD_REQUEST.value(),
            "O corpo da requisição contém JSON malformado",
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // 404 - Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {
        
        ErrorResponse response = new ErrorResponse(
            "NotFound",
            "Recurso não encontrado",
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    // 409 - Conflict (ex: SKU duplicado)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleConflict(
            IllegalArgumentException ex,
            HttpServletRequest request) {
        
        ErrorResponse response = new ErrorResponse(
            "BusinessError",
            "Erro de negócio",
            HttpStatus.CONFLICT.value(),
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    
    // 500 - Erros não tratados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
        
        // Log do erro para monitoramento
        ex.printStackTrace();
        
        ErrorResponse response = new ErrorResponse(
            "InternalError",
            "Erro interno do servidor",
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Ocorreu um erro inesperado. Tente novamente mais tarde.",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}