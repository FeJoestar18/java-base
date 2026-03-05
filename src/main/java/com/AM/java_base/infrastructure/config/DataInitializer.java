package com.AM.java_base.infrastructure.config;

import com.AM.java_base.domain.entities.Role;
import com.AM.java_base.domain.enums.RoleName;
import com.AM.java_base.infrastructure.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {

            for (RoleName roleName : RoleName.values()) {

                roleRepository.findByName(roleName)
                        .orElseGet(() -> roleRepository.save(
                                Role.builder()
                                        .name(roleName)
                                        .build()
                        ));
            }

        };
    }
}