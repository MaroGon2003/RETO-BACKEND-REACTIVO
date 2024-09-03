package com.example.microservicio_tecnologia.domain.exception;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String message) {
        super(message);
    }
}
