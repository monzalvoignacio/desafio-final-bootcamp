package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.ErrorDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDto> apiExceptionHandler(ApiException ex){
        return new ResponseEntity<ErrorDto>(new ErrorDto(ex.getCode(),ex.getDescription(),ex.getStatusCode()), HttpStatus.valueOf(ex.getCode()));
    }

}
