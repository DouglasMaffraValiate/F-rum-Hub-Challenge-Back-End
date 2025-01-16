package com.forumhub.privado.topico.model;


import com.forumhub.privado.curso.model.Curso;
import com.forumhub.privado.resposta.model.Resposta;
import com.forumhub.privado.topico.dto.TopicCreationDTO;
import com.forumhub.privado.usuario.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity(name = "Topico")
@Table(name = "topicos")
@Setter @EqualsAndHashCode(of = "id")
@AllArgsConstructor
@ToString
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> respostas;

    public Topico() {
    }

    public Topico(TopicCreationDTO topicDTO, Optional<Usuario> autor, Optional<Curso> curso) {
        this.titulo = topicDTO.titulo();
        this.mensagem = topicDTO.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = "Ainda sem suloção.";
        this.autor = autor.get();
        this.curso = curso.get();
    }

    public Topico(Topico topico) {
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus();
        this.autor = topico.getAutor();
        this.curso = topico.getCurso();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }
}
