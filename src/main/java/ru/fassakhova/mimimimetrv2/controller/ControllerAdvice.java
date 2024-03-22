package ru.fassakhova.mimimimetrv2.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public void serverErrorExceptionHandler(Exception exception) {
        ResponseEntity
                .internalServerError()
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());
    }

    @ExceptionHandler
    public void entityNotFoundExceptionHandler(EntityNotFoundException exception) {
        ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());
    }

    @ExceptionHandler
    public void illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());
    }
}
