package com.rojudo.spring_lab.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rojudo.spring_lab.exception.ErrorResponse;
import com.rojudo.spring_lab.exception.TraceIdGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * CUSTOM AUTHENTICATION ENTRY POINT
 * 
 * Trata requisições não autenticadas
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        
        String traceId = TraceIdGenerator.generate();
        
        // NOVA ASSINATURA: traceId, status, error, message, path
        ErrorResponse errorResponse = new ErrorResponse(
            traceId,
            HttpStatus.UNAUTHORIZED.value(),
            "Authentication Error",
            "Você precisa estar autenticado para acessar este recurso",
            request.getRequestURI()
        );
        
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }
}