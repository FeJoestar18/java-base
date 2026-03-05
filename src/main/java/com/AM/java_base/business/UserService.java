package com.AM.java_base.business;

import com.AM.java_base.dto.UserRequestDTO;
import com.AM.java_base.infrastructure.entitys.User;
import com.AM.java_base.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserRequestDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .password(dto.getPassword())
                .build();

        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found with email: " + email)
                );
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
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
