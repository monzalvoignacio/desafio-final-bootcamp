package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDto {
    private Integer dealerNumber;
    private List<OrderDto> orders;

}
