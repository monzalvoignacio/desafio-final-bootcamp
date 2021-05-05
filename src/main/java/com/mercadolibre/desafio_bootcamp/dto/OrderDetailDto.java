package com.mercadolibre.desafio_bootcamp.dto;

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
    private String partCode;
    private String description;
    private Integer quantity;
    private String accountType;
    private String reason;
    
}
