package com.forumhub.privado.resposta.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


public record RespostaListingDTO(
        String mensagem,
        LocalDateTime dataCriacao,
        Long idAutor
) {
    public RespostaListingDTO(String mensagem, LocalDateTime dataCriacao, Long idAutor) {
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.idAutor = idAutor;
    }
}
