package com.forumhub.privado.resposta.validacao;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.resposta.dto.RespostaCreationDTO;
import com.forumhub.privado.topico.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarExistsTopicoById implements ValidadorCreationResposta{

    @Autowired
    private TopicoRepository repository;

    @Override
    public void validar(RespostaCreationDTO respostaCreationDTO) {
        if(!repository.existsById(respostaCreationDTO.idTopico()))throw new ValidacaoException("O topico não existe");
    }
}
