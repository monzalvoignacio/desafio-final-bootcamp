package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.models.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class OrderDetailDto {
    private String partCode;
    private String description;
    private Integer quantity;
    private String accountType;
    private String reason;
    
}
