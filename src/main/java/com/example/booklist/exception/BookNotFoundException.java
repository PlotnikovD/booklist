package com.example.booklist.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException() {
    }
}
