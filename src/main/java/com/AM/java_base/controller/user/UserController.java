package com.AM.java_base.controller.user;

import com.AM.java_base.application.dto.user.UserDeleteRequestDTO;
import com.AM.java_base.application.dto.user.UserGetResponseDTO;
import com.AM.java_base.domain.entities.User;
import com.AM.java_base.domain.service.user.UserService;
import com.AM.java_base.application.dto.user.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping
        public ResponseEntity<?> getAllUsers() {

            var users = userService.getAllUsers();

            var response = users.stream()
                    .map(user -> new UserGetResponseDTO(
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getCpf(),
                            user.getRole().getId()
                    ))
                    .toList();

            return ResponseEntity.ok(response);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getUserById(@PathVariable Integer id) {
            User user = userService.getUserById(id);

            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            UserGetResponseDTO response = new UserGetResponseDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCpf(),
                    user.getRole().getId()
            );

            return ResponseEntity.ok(response);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
            UserDeleteRequestDTO dto = new UserDeleteRequestDTO(id);
            userService.deleteUserById(dto.getId());

            return ResponseEntity.ok("User deleted successfully");
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> updateById(@PathVariable Integer id, @RequestBody UserRequestDTO dto) {
            userService.updateById(id, dto);
            return ResponseEntity.ok().build();
        }
}
