package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;

import java.time.LocalDate;

public interface PartsService {
    PartResponseDto getParts(String queryType, LocalDate date, Integer order);
}
