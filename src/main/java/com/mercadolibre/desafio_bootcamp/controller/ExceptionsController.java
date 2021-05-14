package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.ErrorDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDto> apiExceptionHandler(ApiException ex){
        return new ResponseEntity<ErrorDto>(new ErrorDto(ex.getCode(),ex.getDescription(),ex.getStatusCode()), HttpStatus.valueOf(ex.getCode()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
