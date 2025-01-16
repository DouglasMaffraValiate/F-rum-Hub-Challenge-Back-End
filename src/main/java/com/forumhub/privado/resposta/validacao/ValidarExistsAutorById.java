package com.forumhub.privado.resposta.validacao;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.resposta.dto.RespostaCreationDTO;
import com.forumhub.privado.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarExistsAutorById implements ValidadorCreationResposta{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validar(RespostaCreationDTO respostaCreationDTO) {
        if (!repository.existsById(respostaCreationDTO.idAutor()))throw new ValidacaoException("O autor não existe");
    }
}
