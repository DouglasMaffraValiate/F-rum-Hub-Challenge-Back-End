package com.forumhub.privado.usuario.repository;

import com.forumhub.privado.usuario.dto.UserListingDTO;
import com.forumhub.privado.usuario.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT new com.forumhub.privado.usuario.dto.UserListingDTO(u.id, u.nome, u.email) FROM Usuario u")
    Page<UserListingDTO> findAllUserListingDTO(Pageable pageable);

    UserDetails findByEmail(String subject);
}
