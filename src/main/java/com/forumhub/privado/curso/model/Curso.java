package com.forumhub.privado.curso.model;

import com.forumhub.privado.curso.dto.CursoCreateDTO;
import com.forumhub.privado.topico.model.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categorias;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;

    public Curso() {
    }

    public Curso(CursoCreateDTO cursoCreateDTO) {
        this.id = null;
        this.nome = cursoCreateDTO.nome();
        this.categorias = cursoCreateDTO.categorias();
    }

    public String getNome() {
        return nome;
    }

    public String getCategorias() {
        return categorias;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }
}
