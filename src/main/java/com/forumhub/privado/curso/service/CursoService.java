package com.forumhub.privado.curso.service;

import com.forumhub.privado.curso.dto.CursoCreateDTO;
import com.forumhub.privado.curso.model.Curso;
import com.forumhub.privado.curso.repository.CursoRepository;
import com.forumhub.privado.curso.validacoes.ValidadorCriarCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private List<ValidadorCriarCurso> validadores;

    @Autowired
    private CursoRepository repository;

    public ResponseEntity criarCurso(CursoCreateDTO cursoCreateDTO){
        validadores.forEach(v -> v.validar(cursoCreateDTO));
        repository.save(new Curso(cursoCreateDTO));

        return ResponseEntity.ok(cursoCreateDTO);
    }
}
