package com.rojudo.spring_lab.config;

import com.rojudo.spring_lab.exception.TraceIdGenerator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * MDC FILTER
 * 
 * Adiciona Trace ID ao contexto de log para toda requisição
 * Permite rastrear todas as operações de uma mesma requisição
 */
@Component
@Order(1)
public class MdcFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(MdcFilter.class);
    
    private static final String TRACE_ID_HEADER = "X-Trace-Id";
    private static final String MDC_TRACE_KEY = "traceId";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        
        try {
            // Tenta obter Trace ID do header, ou gera novo
            String traceId = request.getHeader(TRACE_ID_HEADER);
            if (traceId == null || traceId.isBlank()) {
                traceId = TraceIdGenerator.generateForMdc();
            }
            
            // Adiciona ao MDC (será incluído em todos os logs da requisição)
            MDC.put(MDC_TRACE_KEY, traceId);
            
            // Adiciona ao response header para o cliente
            response.setHeader(TRACE_ID_HEADER, traceId);
            
            // Log da requisição
            log.info("→ {} {}", request.getMethod(), request.getRequestURI());
            
            filterChain.doFilter(request, response);
            
        } finally {
            // Remove do MDC após a requisição
            MDC.clear();
        }
    }
}