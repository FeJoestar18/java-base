package com.AM.java_base.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRequestDTO {

    private String name;
    private String email;
    private String cpf;
    private String password;
    private Integer roleId;

}