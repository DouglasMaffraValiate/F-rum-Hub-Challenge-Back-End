package com.forumhub.privado.usuario;

import com.forumhub.privado.usuario.dto.UpdateUserDTO;
import com.forumhub.privado.usuario.dto.UserListingDTO;
import com.forumhub.privado.usuario.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/listar")
    @SecurityRequirement(name = "bearer-key")
    public Page<UserListingDTO> listarUsuarios(@PageableDefault(size = 10, page = 0, sort = {"email"}) Pageable paginacao){
        return repository.findAllUserListingDTO(paginacao);
    }

    @PostMapping("/atualizar")
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid UpdateUserDTO userDTO){
        var user = repository.getReferenceById(userDTO.id());
        user.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deletUser(@PathVariable Long id){
        repository.deleteById(id);
    }
}
