package com.rojudo.spring_lab.dto.request;

import jakarta.validation.constraints.*;
import com.rojudo.spring_lab.validation.ValidationGroups;

public record AuthRegisterRequest(
    
    @NotBlank(message = "{auth.fullname.notblank}")
    @Size(min = 3, max = 100, message = "{auth.fullname.size}")
    String fullName,
    
    @NotBlank(message = "{auth.email.notblank}")
    @Email(message = "{auth.email.invalid}")
    String email,
    
    // Validação de senha: mínimo 8 caracteres, pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial
    @NotBlank(message = "{auth.password.notblank}")
    @Size(min = 8, message = "{auth.password.size}")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "{auth.password.pattern}"
    )
    String password,
    
    @Size(max = 20, message = "{auth.phone.size}")
    String phone
    
) {
    // Validação: Se telefone for fornecido, deve ter formato válido
    @AssertTrue(message = "Telefone deve conter apenas números e ter entre 10 e 11 dígitos")
    public boolean isPhoneValid() {
        if (phone == null || phone.isBlank()) {
            return true;
        }
        return phone.matches("^[0-9]{10,11}$");
    }
}