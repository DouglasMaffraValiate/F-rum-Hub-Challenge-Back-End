package com.forumhub.publico.infra.singin.validacao;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.publico.infra.singin.dto.SingInDTO;
import com.forumhub.publico.infra.singin.repository.SingUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorExistEmail implements ValidacaoSingIn{

    @Autowired
    private SingUpRepository repository;

    @Override
    public void validar(SingInDTO dto) {
        if(repository.existsByEmail(dto.email())){
            throw new ValidacaoException("O email informado já esta em uso.");
        }
    }
}