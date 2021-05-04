package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class PartResponseDto {
    private List<PartDto> parts;
}
