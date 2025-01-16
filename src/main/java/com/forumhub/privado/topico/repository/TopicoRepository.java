package com.forumhub.privado.topico.repository;

import com.forumhub.privado.topico.dto.TopicoListingDTO;
import com.forumhub.privado.topico.model.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByMensagem(String mensagem);

    boolean existsByTitulo(String titulo);

    @Query("""
             SELECT new com.forumhub.privado.topico.dto.TopicoListingDTO(t.titulo, a.nome, c.nome, t.mensagem, t.dataCriacao, t.status, t.id)
             FROM Topico t JOIN t.autor a JOIN t.curso c
            """)
    Page<TopicoListingDTO> findAllDTO(Pageable paginacao);
}
