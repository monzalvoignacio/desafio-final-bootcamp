package com.mercadolibre.desafio_bootcamp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String code;
    private String description;
    private Integer statusCode;
}
