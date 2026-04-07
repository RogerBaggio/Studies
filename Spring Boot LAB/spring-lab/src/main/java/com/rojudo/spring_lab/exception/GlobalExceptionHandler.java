package com.rojudo.spring_lab.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GLOBAL EXCEPTION HANDLER
 * 
 * POR QUE?
 * - Tratamento centralizado de exceções
 * - Respostas consistentes
 * - Separa tratamento de erro da lógica de negócio
 * 
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    // ==================== 400 - BAD REQUEST ====================
    
    /**
     * Erros de validação de DTOs (@Valid)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        
        log.warn("[{}] Validation error on {} - Fields: {}", 
            traceId, request.getRequestURI(), errors.keySet());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            "Os dados fornecidos são inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de validação de parâmetros (@RequestParam, @PathVariable)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        Map<String, String> errors = ex.getConstraintViolations().stream()
            .collect(Collectors.toMap(
                violation -> violation.getPropertyPath().toString(),
                ConstraintViolation::getMessage,
                (v1, v2) -> v1
            ));
        
        log.warn("[{}] Constraint violation on {} - Errors: {}", 
            traceId, request.getRequestURI(), errors);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            "Parâmetros inválidos",
            request.getRequestURI(),
            errors
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de tipo incompatível (ex: String ao invés de Long)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        String message = String.format(
            "Parâmetro '%s' deve ser do tipo %s",
            ex.getName(),
            ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "desconhecido"
        );
        
        log.warn("[{}] Type mismatch on {} - {}", traceId, request.getRequestURI(), message);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Type Mismatch",
            message,
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * JSON malformado
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMalformedJson(
            HttpMessageNotReadableException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Malformed JSON on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Malformed JSON",
            "O corpo da requisição contém JSON malformado. Verifique a sintaxe.",
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    /**
     * Erros de validação customizada (ex: @AssertTrue)
     * HTTP 400 - Bad Request
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            ValidationException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Validation error on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.badRequest().body(response);
    }
    
    // ==================== 401 - UNAUTHORIZED ====================
    
    /**
     * Credenciais inválidas (login)
     * HTTP 401 - Unauthorized
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentials(
            BadCredentialsException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Bad credentials attempt on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Failed",
            "Email ou senha inválidos",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    /**
     * Usuário desativado
     * HTTP 401 - Unauthorized
     */
    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleDisabledAccount(
            DisabledException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Disabled account access attempt on {}", traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Account Disabled",
            "Sua conta está desativada. Entre em contato com o administrador.",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    /**
     * Usuário não encontrado
     * HTTP 401 - Unauthorized (não revelar se existe ou não por segurança)
     */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(
            UsernameNotFoundException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] User not found attempt on {}", traceId, request.getRequestURI());
        
        // Mesma mensagem do BadCredentialsException para não revelar existência
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Failed",
            "Email ou senha inválidos",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
    
    // ==================== 403 - FORBIDDEN ====================
    
    /**
     * Acesso negado (usuário autenticado mas sem permissão)
     * HTTP 403 - Forbidden
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDenied(
            AccessDeniedException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Access denied on {} - User lacks required permission", 
            traceId, request.getRequestURI());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.FORBIDDEN.value(),
            "Access Denied",
            "Você não tem permissão para acessar este recurso",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
    
    // ==================== 404 - NOT FOUND ====================
    
    /**
     * Recurso não encontrado
     * HTTP 404 - Not Found
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.info("[{}] Resource not found on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.NOT_FOUND.value(),
            "Resource Not Found",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
    // ==================== 409 - CONFLICT ====================
    
    /**
     * Conflito (ex: SKU duplicado, email já existe)
     * HTTP 409 - Conflict
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleConflict(
            IllegalArgumentException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.info("[{}] Business conflict on {} - {}", traceId, request.getRequestURI(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.CONFLICT.value(),
            "Business Conflict",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    
    // ==================== 422 - UNPROCESSABLE ENTITY ====================
    
    /**
     * Erro de regra de negócio (operação não permitida no estado atual)
     * HTTP 422 - Unprocessable Entity
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.warn("[{}] Business rule violation on {} - Code: {}, Message: {}", 
            traceId, request.getRequestURI(), ex.getErrorCode(), ex.getMessage());
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "Business Rule Violation",
            ex.getMessage(),
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
    
    // ==================== 500 - INTERNAL SERVER ERROR ====================
    
    /**
     * Erros não tratados
     * HTTP 500 - Internal Server Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
        
        String traceId = TraceIdGenerator.generate();
        
        log.error("[{}] Unhandled exception on {} - {}: {}", 
            traceId, request.getRequestURI(), ex.getClass().getSimpleName(), ex.getMessage(), ex);
        
        ErrorResponse response = new ErrorResponse(
            traceId,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            "Ocorreu um erro inesperado. Tente novamente mais tarde.",
            request.getRequestURI()
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}