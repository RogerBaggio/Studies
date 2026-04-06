package com.rojudo.spring_lab.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthLoginResponse( //Token JWT para autenticação nas requisições subsequentes
    String accessToken, // Deve ser enviado no header: Authorization: Bearer {token}
    String tokenType, // Tipo do token (padrão OAuth2). Sempre "Bearer"
    Long expiresIn, // Tempo de expiração do token em segundos. Padrão: 3600 segundos (1 hora)
    UserInfoResponse user
) {
    public AuthLoginResponse(String accessToken, UserInfoResponse user) {
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
        return String.format("AuthLoginResponse{tokenType='%s', expiresIn=%d, user=%s}",
            tokenType, expiresIn, user);
    }
}
