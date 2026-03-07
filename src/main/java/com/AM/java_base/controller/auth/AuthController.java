package com.AM.java_base.controller.auth;

import com.AM.java_base.application.dto.auth.AuthDTO;
import com.AM.java_base.application.dto.auth.LoginResponseDTO;
import com.AM.java_base.application.dto.user.UserRequestDTO;
import com.AM.java_base.domain.entities.User;
import com.AM.java_base.domain.service.auth.AuthService;
import com.AM.java_base.infrastructure.security.TokenGenerateService;
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
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    private AuthService authService;
    @Autowired
    private TokenGenerateService tokenGenerateService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated AuthDTO authDTO) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(
                authDTO.getEmail(),
                authDTO.getPassword()
        );

        var auth = authenticationManager.authenticate(usernamePassword);

        User user = (User) auth.getPrincipal();

        var token = tokenGenerateService.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequestDTO dto) {
        authService.registerUser(dto);

        return  ResponseEntity.ok("Registro realizado com sucesso");
    }
}
