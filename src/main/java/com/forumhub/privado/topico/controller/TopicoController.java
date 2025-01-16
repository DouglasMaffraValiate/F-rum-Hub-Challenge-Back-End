package com.forumhub.privado.topico.controller;


import com.forumhub.privado.topico.criarTopico.CriarTopico;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.topico.dto.TopicoListingDTO;
import com.forumhub.privado.topico.model.Topico;
import com.forumhub.privado.topico.repository.TopicoRepository;
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
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private CriarTopico topicoService;

    @Autowired
    private TopicoRepository repository;

    @PostMapping("/novo")
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid TopicCreationDTO topicDTO){
        return topicoService.criar(topicDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<TopicoListingDTO>> listar(@PageableDefault(size = 10, page = 0, sort = {"titulo"})Pageable paginacao){
        var lista = repository.findAllDTO(paginacao);
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleterId(@PathVariable Long id){
        repository.deleteById(id);
    }
}
