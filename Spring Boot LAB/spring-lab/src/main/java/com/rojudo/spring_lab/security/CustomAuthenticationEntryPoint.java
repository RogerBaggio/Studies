package com.rojudo.spring_lab.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rojudo.spring_lab.exception.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        
        Map<String, String> details = new HashMap<>();
        details.put("timestamp", LocalDateTime.now().toString());
        details.put("path", request.getRequestURI());

        ErrorResponse errorResponse = new ErrorResponse(
            "AuthenticationError",
            "Não autenticado", 
            HttpStatus.UNAUTHORIZED.value(),
            "Você precisa estar autenticado para acessar este recurso",
            request.getRequestURI(),
            details
        );
        
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getOutputStream(), errorResponse);
    }
}