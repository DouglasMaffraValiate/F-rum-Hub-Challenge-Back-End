package com.forumhub.privado.curso.repository;

import com.forumhub.privado.curso.dto.CursoListingDTO;
import com.forumhub.privado.curso.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByNome(String nome);

    @Query("SELECT new com.forumhub.privado.curso.dto.CursoListingDTO(c.id, c.nome, c.categorias) FROM Curso c")
    Page<CursoListingDTO> findAllDTO(Pageable paginacao);
}
