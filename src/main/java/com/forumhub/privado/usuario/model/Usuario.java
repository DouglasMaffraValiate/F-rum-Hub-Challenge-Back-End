package com.forumhub.privado.usuario.model;


import com.forumhub.privado.resposta.model.Resposta;
import com.forumhub.privado.topico.model.Topico;
import com.forumhub.privado.usuario.dto.UpdateUserDTO;
import com.forumhub.publico.infra.singin.dto.SingInDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@ToString
public class Usuario implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioPerfil usuarioPerfil;

    @OneToMany(mappedBy = "autor")
    private List<Resposta> respostas;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    public Usuario() {
    }

    public Usuario(SingInDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.usuarioPerfil = dto.perfil();
    }

    public Usuario(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.usuarioPerfil = usuario.getUsuarioPerfil();
    }


    public void updateUser(@Valid UpdateUserDTO userDTO) {
        if (userDTO.nome() != null) this.nome = userDTO.nome();
        if (userDTO.email() != null) this.email = userDTO.email();
    }

    public String getNome() {
        return nome;
    }

    public UsuarioPerfil getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
