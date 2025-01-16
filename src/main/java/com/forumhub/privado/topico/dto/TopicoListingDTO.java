package com.forumhub.privado.topico.dto;

import java.time.LocalDateTime;

public record TopicoListingDTO(
        String titulo,

        String nomeAutor,

        String nomeCurso,

        String mensagem,

        LocalDateTime dataCriacao,

        String status,

        Long id
) {
}
