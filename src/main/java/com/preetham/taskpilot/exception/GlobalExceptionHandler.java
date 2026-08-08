package com.preetham.taskpilot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.preetham.taskpilot.exception.ResourceNotFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }
    @ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
        ResourceNotFoundException ex,
        HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            request.getRequestURI()
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
}
@ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsException(
        EmailAlreadyExistsException ex,
        HttpServletRequest request) {

    ErrorResponse error = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.CONFLICT.value(),
            ex.getMessage(),
            request.getRequestURI()
    );

    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
}
}