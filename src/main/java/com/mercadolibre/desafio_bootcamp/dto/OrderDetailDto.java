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
    @JsonProperty("description")
    private String description;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("reason")
    private String reason;

}
