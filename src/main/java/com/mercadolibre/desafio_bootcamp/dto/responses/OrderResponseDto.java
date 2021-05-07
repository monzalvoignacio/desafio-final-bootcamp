package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    @JsonProperty("dealerNumber")
    private Long dealerNumber;
    private List<OrderDto> orders;

}
