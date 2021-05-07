package com.mercadolibre.desafio_bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.desafio_bootcamp.models.DeliveryStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    @JsonProperty("partCode")
    private String partCode;
    private String description;
    private Integer quantity;
    @JsonProperty("accountType")
    private String accountType;
    private String reason;
    
}
