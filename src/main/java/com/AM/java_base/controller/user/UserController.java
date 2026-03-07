package com.AM.java_base.controller.user;

import com.AM.java_base.application.dto.user.UserDeleteRequestDTO;
import com.AM.java_base.application.dto.user.UserGetDTO;
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

        @GetMapping()
        public ResponseEntity<?> getUserById(@PathVariable UserGetDTO dto) {
            Integer id = dto.getId();
            return ResponseEntity.ok(userService.getUserById(id));
        }

        @DeleteMapping
        public ResponseEntity<String> deleteUser(@RequestBody UserDeleteRequestDTO dto) {
            userService.deleteUserById(dto.getId());

            return ResponseEntity.ok("User deleted successfully");
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> updateById(@PathVariable Integer id, @RequestBody UserRequestDTO dto) {
            userService.updateById(id, dto);
            return ResponseEntity.ok().build();
        }
}
