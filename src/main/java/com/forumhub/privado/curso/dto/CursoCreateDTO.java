package com.forumhub.privado.curso.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record CursoCreateDTO(

        @JsonAlias("nome")
        @NotBlank(message = "O nome do curso é obrigatório.")
        String nome,

        @JsonAlias("categoria")
        @NotBlank(message = "O curso tem que ter no minimo uma categoria obrigatória.")
        String categorias
) {
}
