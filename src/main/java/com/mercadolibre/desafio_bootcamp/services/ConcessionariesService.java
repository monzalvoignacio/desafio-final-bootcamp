package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;

import java.util.List;

public interface ConcessionariesService {
    ConcessionarieDto createConcessionarie(ConcessionarieDto newConcessionarie, String centralHouseId);
    ConcessionarieDto updateConcessionarie(ConcessionarieDto newConcessionarie);
    void deleteConcessionarie(String id);
    List<ConcessionarieDto> getConcessionaries(String centralHouseId);
}
