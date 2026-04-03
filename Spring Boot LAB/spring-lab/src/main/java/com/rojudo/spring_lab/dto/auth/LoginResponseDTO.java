package com.rojudo.spring_lab.dto.auth;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * LOGIN RESPONSE DTO
 * 
 * Resposta do endpoint de login contendo o token JWT e informações do usuário
 * 
 * PRINCÍPIOS:
 * - Record: Imutável e conciso
 * - UserInfoDTO: Usa a classe separada (não inner class)
 * - Token Bearer: Padrão OAuth2
 * 
 * ESTRUTURA:
 * - accessToken: JWT para autenticação
 * - tokenType: Sempre "Bearer" (padrão OAuth2)
 * - expiresIn: Tempo de vida do token em segundos
 * - user: Informações do usuário autenticado
 * 
 * @see UserInfoDTO
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoginResponseDTO( //Token JWT para autenticação nas requisições subsequentes
    String accessToken, // Deve ser enviado no header: Authorization: Bearer {token}
    String tokenType, // Tipo do token (padrão OAuth2). Sempre "Bearer"
    Long expiresIn, // Tempo de expiração do token em segundos. Padrão: 3600 segundos (1 hora)
    UserInfoDTO user
) {
    public LoginResponseDTO(String accessToken, UserInfoDTO user) {
        this(accessToken, "Bearer", 3600L, user);
    }

    // Verifica se o token está presente e não é vazio, para validações antes de usar o token
    public boolean hasToken() {
        return accessToken != null && !accessToken.isBlank();
    }

    //Retorna o token pronto para uso no header Authorization. Exemplo: "Bearer eyJhbGciOiJIUzI1NiIs..."
    public String getAuthorizationHeader() { 

        return tokenType + " " + accessToken;
    }

    @Override
    public String toString() { //Representação simplificada para logs (não expõe o token completo)
        return String.format("LoginResponseDTO{tokenType='%s', expiresIn=%d, user=%s}",
            tokenType, expiresIn, user);
    }
}
