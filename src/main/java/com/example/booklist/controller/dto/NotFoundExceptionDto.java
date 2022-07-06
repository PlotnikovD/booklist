package com.example.booklist.controller.dto;

public class NotFoundExceptionDto {
    public String message;

    public NotFoundExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
