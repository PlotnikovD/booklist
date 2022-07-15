package com.example.booklist.exception;

import com.example.booklist.controller.dto.NotFoundExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NotFoundHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> handleConflict(BookNotFoundException ex) {
        return new ResponseEntity<>(new NotFoundExceptionDto(ex.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }
}