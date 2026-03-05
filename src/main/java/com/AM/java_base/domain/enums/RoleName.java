package com.AM.java_base.domain.enums;

public enum RoleName {

    ADMIN("admin"),
    USER("user"),
    MANAGER("manager");

    private String role;

    RoleName(String role) {
        this.role = role;
    }

}