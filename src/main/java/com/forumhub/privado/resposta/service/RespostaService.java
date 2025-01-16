package com.forumhub.privado.resposta.service;

import com.forumhub.privado.resposta.dto.ListingRespostasPorTopico;
import com.forumhub.privado.resposta.dto.RespostaCreationDTO;
import com.forumhub.privado.resposta.dto.RespostaListingDTO;
import com.forumhub.privado.resposta.model.Resposta;
import com.forumhub.privado.resposta.repository.RespostaRepository;
import com.forumhub.privado.resposta.validacao.ValidadorCreationResposta;
import com.forumhub.privado.topico.dto.TopicoListingDTO;
import com.forumhub.privado.topico.model.Topico;
import com.forumhub.privado.topico.repository.TopicoRepository;
import com.forumhub.privado.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    @Autowired
    private List<ValidadorCreationResposta> validadores;

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public ResponseEntity criar(RespostaCreationDTO respostaCreationDTO){
        validadores.forEach(v -> v.validar(respostaCreationDTO));
        System.out.println(respostaCreationDTO);

        var opuser = usuarioRepository.findById(respostaCreationDTO.idAutor());
        if (!opuser.isPresent()) {
            return ResponseEntity.ok("Usuário inválido!");
        }
        var user = opuser.get();
        System.out.println(user);

        var optop = topicoRepository.findById(respostaCreationDTO.idTopico());
        if (!optop.isPresent()) {
            return ResponseEntity.ok("Tópico inválido!");
        }
        var topico = optop.get();
        System.out.println(topico);

        var resposta = new Resposta(respostaCreationDTO, user, topico);
        System.out.println(resposta);

        return ResponseEntity.ok(repository.save(resposta));
    }

    public ResponseEntity<ListingRespostasPorTopico> listarREspostasTopico(Long idTopico) {

        var topicoOptional = topicoRepository.findById(idTopico);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var topico = topicoOptional.get();
        var topicoDTO = new TopicoListingDTO(
                topico.getTitulo(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getId()
        );
        System.out.println(topicoDTO);

        var respostas = repository.findAllByTopicoId(idTopico);
        System.out.println(respostas);
        respostas.forEach(System.out::println);

        return ResponseEntity.ok(new ListingRespostasPorTopico(topicoDTO, respostas));
    }
}
