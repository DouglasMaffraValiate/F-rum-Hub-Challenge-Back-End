package com.forumhub.privado.resposta.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespostaCreationDTO(

        @JsonAlias("mensagem")
        @NotBlank(message = "Não é possivel criar um aresposta sem texto!")
        String mensagem,

        @JsonAlias("idTopico")
        @NotNull(message = "É obrigatório informar o id do topico.")
        Long idTopico,

        @JsonAlias("idAutor")
        @NotNull(message = "É obrigatório informar o id do autor.")
        Long idAutor
) {
}
