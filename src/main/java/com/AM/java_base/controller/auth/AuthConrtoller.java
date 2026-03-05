package com.AM.java_base.controller.auth;

import com.AM.java_base.application.dto.auth.AuthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthConrtoller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthDTO authDTO) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authDTO.getEmail(),
                authDTO.getPassword()
        );

        var auth = authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok("Login realizado com sucesso");
    }
}
