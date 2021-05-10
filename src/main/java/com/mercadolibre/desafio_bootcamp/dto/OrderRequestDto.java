package com.mercadolibre.desafio_bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    @JsonProperty("centralHouseId")
    private Long centralHouseId;
    @JsonProperty("consessionarieId")
    private Long consessionarieId;
    @JsonProperty("shippingType")
    private String shippingType;
    @JsonProperty("parts")
    private List<OrderDetailDto> parts;
}
