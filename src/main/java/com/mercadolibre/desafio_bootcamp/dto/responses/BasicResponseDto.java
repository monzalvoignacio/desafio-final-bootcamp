package com.mercadolibre.desafio_bootcamp.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicResponseDto {
    private HttpStatus httpStatus;
    private String message;
}
