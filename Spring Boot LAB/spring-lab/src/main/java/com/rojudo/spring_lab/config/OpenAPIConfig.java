package com.rojudo.spring_lab.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Spring Lab API")
                .version("0.0.2")
                .description("""
                    REST API Lab para e-commerce com Spring Boot.
                    
                    ## Funcionalidades:
                    * CRUD completo de produtos
                    * Autenticação JWT
                    * Controle de permissões (RBAC)
                    * Paginação e filtros
                    
                    ## Fluxo de autenticação:
                    1. Faça login em `/api/v1/auth/login`
                    2. Copie o token recebido
                    3. Clique no botão "Authorize" abaixo e insira: `Bearer {seu-token}`
                    """)
                .contact(new Contact()
                    .name("Roger Baggio")
                    .email("fakecontato@email.com")
                    .url("https://github.com/RogerBaggio"))
                .license(new License()
                    .name("MIT License")
                    .url("https://opensource.org/licenses/MIT")))
            .servers(List.of(
                new Server()
                    .url("http://localhost:8080")
                    .description("Servidor de Desenvolvimento"),
                new Server()
                    .url("https://api.prod.springlabfakesite.com")
                    .description("Servidor de Produção fake")))
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                    .description("Insira o token JWT obtido no login. Exemplo: Bearer eyJhbGciOiJIUzI1...")))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}