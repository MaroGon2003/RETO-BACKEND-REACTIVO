package com.example.microservicio_tecnologia.infrastructure.config;

import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleInvalidInput(InvalidInputException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
    }
}

