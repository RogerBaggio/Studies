package com.rojudo.spring_lab.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuditListener {
    
    private static final Logger auditLog = LoggerFactory.getLogger("AUDIT");
    
    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        String username = event.getAuthentication().getName();
        String ip = getClientIp(event);
        
        auditLog.info("LOGIN_SUCCESS - User: {}, IP: {}", username, ip);
    }
    
    @EventListener
    public void onAuthenticationFailure(AbstractAuthenticationFailureEvent event) {
        String username = event.getAuthentication().getName();
        String ip = getClientIp(event);
        String reason = event.getException().getMessage();
        
        auditLog.warn("LOGIN_FAILURE - User: {}, IP: {}, Reason: {}", username, ip, reason);
    }
    
    private String getClientIp(AuthenticationSuccessEvent event) {
        if (event.getAuthentication().getDetails() instanceof WebAuthenticationDetails details) {
            return details.getRemoteAddress();
        }
        return "unknown";
    }
    
    private String getClientIp(AbstractAuthenticationFailureEvent event) {
        if (event.getAuthentication().getDetails() instanceof WebAuthenticationDetails details) {
            return details.getRemoteAddress();
        }
        return "unknown";
    }
}