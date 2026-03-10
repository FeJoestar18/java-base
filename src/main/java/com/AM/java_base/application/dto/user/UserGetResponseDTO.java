package com.AM.java_base.application.dto.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserGetResponseDTO {

    private Integer id;
    private String name;
    private String email;
    private String cpf;
    private Integer roleId;

}