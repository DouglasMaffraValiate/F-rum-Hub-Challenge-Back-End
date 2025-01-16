package com.forumhub.privado.resposta.repository;

import com.forumhub.privado.resposta.dto.RespostaListingDTO;
import com.forumhub.privado.resposta.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    @Query("SELECT new com.forumhub.privado.resposta.dto.RespostaListingDTO(r.mensagem, r.dataCriacao, r.autor.id) FROM Resposta r WHERE r.topico.id = :idTopico")
    List<RespostaListingDTO> findAllByTopicoId(Long idTopico);

}
