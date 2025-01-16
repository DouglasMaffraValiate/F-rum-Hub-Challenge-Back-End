package com.forumhub.privado.resposta.controller;

import com.forumhub.privado.resposta.dto.ListingRespostasPorTopico;
import com.forumhub.privado.resposta.dto.RespostaCreationDTO;
import com.forumhub.privado.resposta.service.RespostaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @PostMapping("/responder")
    @Transactional
    public ResponseEntity responder(@RequestBody @Valid RespostaCreationDTO respostaCreationDTO){
        return ResponseEntity.ok(service.criar(respostaCreationDTO));
    }

    @GetMapping("/{idTopico}")
    public ResponseEntity<ListingRespostasPorTopico> verRespostas(@PathVariable Long idTopico){
        return ResponseEntity.ok(service.listarREspostasTopico(idTopico).getBody());
    }
}
