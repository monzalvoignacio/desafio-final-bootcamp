package com.mercadolibre.desafio_bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @JsonProperty("orderNumber")
    private Integer orderNumber;
    @JsonProperty("orderDate")
    private String orderDate;
    @JsonProperty("deliveryDate")
    private String deliveryDate;
    @JsonProperty("daysDelayed")
    private Integer daysDelayed;
    @JsonProperty("deliveryStatus")
    private String deliveryStatus;
    @JsonProperty("orderDetails")
    private List<OrderDetailDto> orderDetails;
    
}
