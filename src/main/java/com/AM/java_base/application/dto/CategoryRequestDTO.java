package com.AM.java_base.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryRequestDTO {

    private String name;
    private String description;

}