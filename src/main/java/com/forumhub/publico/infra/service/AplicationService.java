package com.forumhub.publico.infra.service;

import com.forumhub.privado.usuario.model.Usuario;
import com.forumhub.publico.infra.login.dto.LoginDTO;
import com.forumhub.publico.infra.security.DadosTokenJWT;
import com.forumhub.publico.infra.security.TokenService;
import com.forumhub.publico.infra.singin.dto.SingInDTO;
import com.forumhub.publico.infra.singin.repository.SingUpRepository;
import com.forumhub.publico.infra.singin.validacao.ValidacaoSingIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AplicationService {

    @Autowired
    private List<ValidacaoSingIn> validadores;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private SingUpRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity login(LoginDTO dto){
        try {
            var token = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
            var authentication = manager.authenticate(token);
            var usuario = (Usuario) authentication.getPrincipal();

            var gTokenJWT = tokenService.gerarToken(usuario);
            return ResponseEntity.ok(new DadosTokenJWT(gTokenJWT));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao autenticar: " + e.getMessage());
        }
    }

    public ResponseEntity SingIn(SingInDTO dto){
       try {
            validadores.forEach(v -> v.validar(dto));

            String senhaCodificada = passwordEncoder.encode(dto.senha());

            var user = new Usuario(dto);
            user.setSenha(senhaCodificada);

            repository.save(user);

            return ResponseEntity.ok("Usuário criado com sucesso! ID: " + user.getEmail());
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao criar usuário: " + e.getMessage());
        }
    }
}
