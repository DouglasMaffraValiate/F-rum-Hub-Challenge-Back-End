package com.forumhub.privado.topico.criarTopico.validacoes;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarUsuario implements ValidadorCriarTopico{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(TopicCreationDTO creationDTO) {

        if (!repository.existsById(creationDTO.autorId())){
            throw new ValidacaoException("Usuario do id informado não existe!");
        }
    }
}
