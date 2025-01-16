package com.forumhub.publico.infra.login.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginDTO(
        @JsonAlias("email")
        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "O email deve ser válido.")
        String email,

        @JsonAlias("senha")
        @NotBlank(message = "A senha é obrigatória! A SENHA deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial.")
        @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
        @Pattern(regexp = ".*[A-Z].*", message = "A senha deve conter pelo menos uma letra maiúscula.")
        @Pattern(regexp = ".*[a-z].*", message = "A senha deve conter pelo menos uma letra minúscula.")
        @Pattern(regexp = ".*\\d.*", message = "A senha deve conter pelo menos um número.")
        @Pattern(regexp = ".*[@$!%*?&].*", message = "A senha deve conter pelo menos um caractere especial (@, $, !, %, *, ?, &).")
        String senha
) {
}
