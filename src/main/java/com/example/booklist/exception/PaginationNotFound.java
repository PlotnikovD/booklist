package com.example.booklist.exception;

public class PaginationNotFound extends RuntimeException {
    public PaginationNotFound() {
    }

    public PaginationNotFound(String message) {
        super(message);
    }
}
