package com.forumhub.privado.topico.criarTopico.validacoes;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.topico.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoMensagem implements ValidadorCriarTopico{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(TopicCreationDTO creationDTO) {
        if(repository.existsByMensagem(creationDTO.mensagem())){
            throw new ValidacaoException("Já existe topico com a mesma mensagem!");
        }
    }
}
