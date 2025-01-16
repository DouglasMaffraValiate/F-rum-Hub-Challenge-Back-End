package com.forumhub.privado.usuario.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UpdateUserDTO(
        @JsonAlias("id")
        @NotNull(message = "O id do Usuario é obrigatorio")
        Long id,

        @JsonAlias("nome")
        String nome,

        @JsonAlias("email")
        @Email(message = "O email deve ser válido.")
        String email
) {
}
