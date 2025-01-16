package com.forumhub.privado.resposta.dto;

import com.forumhub.privado.topico.dto.TopicoListingDTO;

import java.util.List;

public record ListingRespostasPorTopico(
        TopicoListingDTO topico,
        List<RespostaListingDTO> respostas
) {
}
