package com.forumhub.privado.resposta.model;

import com.forumhub.privado.resposta.dto.RespostaCreationDTO;
import com.forumhub.privado.topico.model.Topico;
import com.forumhub.privado.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Resposta")
@Table(name = "respostas")
@Getter @Setter @EqualsAndHashCode(of = "id")
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private Boolean solucao;


    public Resposta(RespostaCreationDTO respostaCreationDTO, Usuario user, Topico topico) {
        this.id = null;
        this.mensagem = respostaCreationDTO.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.topico = topico;
        this.autor = user;
        this.solucao = false;
    }
}
