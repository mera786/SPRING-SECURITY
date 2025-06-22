package com.app.dto;

import lombok.Data;

@Data
public class APIResponse<T> {

    private String message;
    private int status;
    private T data;

}
