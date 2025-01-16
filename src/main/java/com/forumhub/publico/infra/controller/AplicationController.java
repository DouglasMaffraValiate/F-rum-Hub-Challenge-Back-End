package com.forumhub.publico.infra.controller;

import com.forumhub.publico.infra.login.dto.LoginDTO;
import com.forumhub.publico.infra.service.AplicationService;
import com.forumhub.publico.infra.singin.dto.SingInDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AplicationController {

    @Autowired
    private AplicationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO dto){
        return service.login(dto);
    }

    @PostMapping("/sing_up")
    public ResponseEntity singUp(@RequestBody @Valid SingInDTO dto){
        return service.SingIn(dto);
    }

}
