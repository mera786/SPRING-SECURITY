package com.app.dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {

    private String email;
    private String username;
    private String newPassword;
    private String oldPassword;

}
