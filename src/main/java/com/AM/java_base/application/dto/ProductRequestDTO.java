package com.AM.java_base.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductRequestDTO {

    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity ;
    private Integer CategoryId;

}