package com.forumhub.privado.curso.controller;

import com.forumhub.privado.curso.dto.CursoCreateDTO;
import com.forumhub.privado.curso.dto.CursoListingDTO;
import com.forumhub.privado.curso.model.Curso;
import com.forumhub.privado.curso.repository.CursoRepository;
import com.forumhub.privado.curso.service.CursoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-Key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private CursoService service;

    @PostMapping("/criar")
    @Transactional
    public ResponseEntity criarCurso(@RequestBody @Valid CursoCreateDTO cursoDTO){
        return ResponseEntity.ok(repository.save(new Curso(cursoDTO)));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<CursoListingDTO>> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(repository.findAllDTO(paginacao));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }


}
