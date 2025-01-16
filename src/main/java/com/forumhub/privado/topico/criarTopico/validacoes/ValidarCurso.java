package com.forumhub.privado.topico.criarTopico.validacoes;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.curso.repository.CursoRepository;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCurso implements ValidadorCriarTopico{

    @Autowired
    private CursoRepository repository;

    @Override
    public void validar(TopicCreationDTO creationDTO) {
        if (!repository.existsById(creationDTO.cursoId())){
            throw new ValidacaoException("Curso do id informado não existe!");
        }
    }
}
