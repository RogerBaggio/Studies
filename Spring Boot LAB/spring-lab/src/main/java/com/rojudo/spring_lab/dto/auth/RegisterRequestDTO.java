package com.rojudo.spring_lab.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    String fullName,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,
    
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, message = "Senha deve ter no mínimo 8 caracteres")
    String password,
    
    @Size(max = 20, message = "Telefone deve ter no máximo 20 caracteres")
    String phone
) {}