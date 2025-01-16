package com.forumhub.privado.topico.criarTopico.validacoes;

import com.forumhub.privado.topico.dto.TopicCreationDTO;

public interface ValidadorCriarTopico {

    void validar(TopicCreationDTO creationDTO);
}
