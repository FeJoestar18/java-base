package com.AM.java_base.domain.service.user;

import com.AM.java_base.application.dto.user.UserRequestDTO;
import com.AM.java_base.domain.entities.Role;
import com.AM.java_base.domain.entities.User;
import com.AM.java_base.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with email: " + id)
                );
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateById(Integer id, UserRequestDTO dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );

        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        if (dto.getEmail() != null) {
            user.setEmail(dto.getEmail());
        }

        userRepository.save(user);
    }
}
