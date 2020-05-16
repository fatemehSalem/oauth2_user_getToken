package com.university.javaeeproject.util;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private int status;
    private String message;
    private Object result;

    public ApiResponse(HttpStatus status, String message, Object result){
        this.status = status.value();
        this.message = message;
        this.result = result;
    }
}
