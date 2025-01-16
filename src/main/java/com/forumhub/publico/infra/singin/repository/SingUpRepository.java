package com.forumhub.publico.infra.singin.repository;

import com.forumhub.privado.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface SingUpRepository extends JpaRepository<Usuario, Long> {

    boolean existsByNome(String nome);

    boolean existsByEmail(String email);

    UserDetails findByEmail(String username);
}
