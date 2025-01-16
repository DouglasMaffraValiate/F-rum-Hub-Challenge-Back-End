package com.forumhub.publico.infra.singin.validacao;


import com.forumhub.publico.infra.singin.dto.SingInDTO;

public interface ValidacaoSingIn {
    void validar(SingInDTO dto);
}
