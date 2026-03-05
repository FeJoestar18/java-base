package com.AM.java_base.controller;

import com.AM.java_base.domain.service.UserService;
import com.AM.java_base.application.dto.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<Void> registerUser(@RequestBody UserRequestDTO dto) {
            userService.registerUser(dto);
            return  ResponseEntity.ok().build();
        }

        @GetMapping
        public ResponseEntity<?> getUserByEmail(@RequestParam UserRequestDTO dto) {
            String email = dto.getEmail();
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }

        @DeleteMapping
        public ResponseEntity<Void> deleteUserByEmail(@RequestParam UserRequestDTO dto) {
            String email = dto.getEmail();

            userService.deleteUserByEmail(email);
            return ResponseEntity.ok().build();
        }

        @PutMapping
        public ResponseEntity<Void> updateById(@RequestParam Integer id, @RequestBody UserRequestDTO dto) {
            userService.updateById(id, dto);
            return ResponseEntity.ok().build();
        }
}
