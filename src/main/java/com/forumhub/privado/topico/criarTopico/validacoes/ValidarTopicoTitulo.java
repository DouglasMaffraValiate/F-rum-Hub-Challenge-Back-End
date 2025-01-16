package com.forumhub.privado.topico.criarTopico.validacoes;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.topico.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoTitulo implements ValidadorCriarTopico{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(TopicCreationDTO creationDTO) {
        if (repository.existsByTitulo(creationDTO.titulo())){
            throw new ValidacaoException("Já existe tópico com esse titulo.");
        }
    }
}
