package com.rojudo.spring_lab.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Disabled("Docker não disponível - executar testes de Service e Repository apenas")
class ProductControllerTest {

    @Test
    void contextLoads() {
        // Teste mínimo para validação do contexto
    }
}