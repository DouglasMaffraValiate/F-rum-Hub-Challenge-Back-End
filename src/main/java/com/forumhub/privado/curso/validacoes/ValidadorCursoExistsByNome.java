package com.forumhub.privado.curso.validacoes;

import com.forumhub.exeption.ValidacaoException;
import com.forumhub.privado.curso.dto.CursoCreateDTO;
import com.forumhub.privado.curso.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorCursoExistsByNome implements ValidadorCriarCurso{

    @Autowired
    private CursoRepository repository;

    @Override
    public void validar(CursoCreateDTO cursoCreateDTO) {
        if (repository.existsByNome(cursoCreateDTO.nome()))throw new ValidacaoException("Já existe curso com o nome informado.");
    }
}
