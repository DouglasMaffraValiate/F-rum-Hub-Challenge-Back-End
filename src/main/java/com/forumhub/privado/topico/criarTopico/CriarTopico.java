package com.forumhub.privado.topico.criarTopico;

import com.forumhub.privado.curso.repository.CursoRepository;
import com.forumhub.privado.topico.criarTopico.validacoes.ValidadorCriarTopico;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.topico.model.Topico;
import com.forumhub.privado.topico.repository.TopicoRepository;
import com.forumhub.privado.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriarTopico {

    @Autowired
    private List<ValidadorCriarTopico> validadores;

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity criar(TopicCreationDTO topicCreationDTO){
        validadores.forEach(v -> v.validar(topicCreationDTO));

        repository.save(new Topico(
                topicCreationDTO,
                usuarioRepository.findById(topicCreationDTO.autorId()),
                cursoRepository.findById(topicCreationDTO.cursoId()))
        );
        return ResponseEntity.ok(topicCreationDTO);
    }

}
