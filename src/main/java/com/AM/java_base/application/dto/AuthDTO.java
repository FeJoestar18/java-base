package com.AM.java_base.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuthDTO {

    private String email;
    private String password;

}