package com.forumhub.privado.topico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TopicCreationDTO(
        @JsonAlias("titulo")
        @NotBlank(message = "O titulo é obrigatorio.")
        String titulo,

        @JsonAlias("mensagem")
        @NotBlank(message = "A mensagem é obrigatória.")
        String mensagem,

        @JsonAlias("autorId")
        @NotNull(message = "O id do autor não pode ser nulo")
        Long autorId,

        @JsonAlias("cursoId")
        @NotNull(message = "O id do curso não pode ser nulo")
        Long cursoId
) {
}
