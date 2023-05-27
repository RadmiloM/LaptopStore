package com.laptop.LaptopStore.controller;

import com.laptop.LaptopStore.exception.LaptopNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LaptopNotFoundException.class)
    public ResponseEntity<String> handleLaptopNotFoundException(LaptopNotFoundException laptopNotFoundException) {
        return new ResponseEntity<>(laptopNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exceptions,
                                                               HttpHeaders headers,
                                                               HttpStatus status,
                                                               WebRequest request) {
        HashMap<String, String> laptopErrors = new HashMap<>();
        exceptions.getBindingResult().getAllErrors().forEach((error) -> {
            String laptopFieldError = ((FieldError) error).getField();
            String laptopMessage = error.getDefaultMessage();
            laptopErrors.put(laptopFieldError, laptopMessage);

        });
        return new ResponseEntity<>(laptopErrors, HttpStatus.BAD_REQUEST);
    }

}
