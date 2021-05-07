package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.NewPartDto;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;

import java.time.LocalDate;

public interface PartsService {
    PartResponseDto getParts(String queryType, String date, String order) throws Exception;
    Integer updateStock(String partCode, Integer quantity);
    NewPartDto createPart(NewPartDto newPart);
}
