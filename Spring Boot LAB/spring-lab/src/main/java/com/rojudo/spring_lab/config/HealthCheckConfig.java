package com.rojudo.spring_lab.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * HEALTH CHECK PERSONALIZADO
 * 
 * Endpoints:
 * - /actuator/health/liveness  → App está viva?
 * - /actuator/health/readiness → App está pronta para receber tráfego?
 */
@Component
public class HealthCheckConfig implements HealthIndicator {
    
    private final MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
    
    @Override
    public Health health() {
        long heapUsed = memoryBean.getHeapMemoryUsage().getUsed();
        long heapMax = memoryBean.getHeapMemoryUsage().getMax();
        double heapUsagePercent = (double) heapUsed / heapMax * 100;
        
        return Health.up()
            .withDetail("memory.heap.used", String.format("%.2f MB", heapUsed / 1024.0 / 1024.0))
            .withDetail("memory.heap.max", String.format("%.2f MB", heapMax / 1024.0 / 1024.0))
            .withDetail("memory.heap.usage", String.format("%.2f%%", heapUsagePercent))
            .build();
    }
}