package com.app.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

    private long id;

    private String name;

    private String username;

    private String email;

    private String password;

    private String role;
}
