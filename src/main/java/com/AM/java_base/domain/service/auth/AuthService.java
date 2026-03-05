package com.AM.java_base.domain.service.auth;

import com.AM.java_base.application.dto.user.UserRequestDTO;
import com.AM.java_base.domain.entities.Role;
import com.AM.java_base.domain.entities.User;
import com.AM.java_base.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
            this.passwordEncoder = passwordEncoder;
            this.userRepository = userRepository;
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void registerUser(UserRequestDTO dto) {

        Role role = new Role();
        role.setId(dto.getRoleId());

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(role)
                .build();

        userRepository.save(user);
    }
}
