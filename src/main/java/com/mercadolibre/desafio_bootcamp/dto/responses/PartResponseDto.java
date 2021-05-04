package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class PartResponseDto {
    private List<PartDto> parts;
}
