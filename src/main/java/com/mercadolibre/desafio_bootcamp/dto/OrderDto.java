package com.mercadolibre.desafio_bootcamp.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderNumber;
    private String orderDate;
    private String deliveryDate;
    private Integer daysDelayed;
    private String deliveryStatus;
    private List<OrderDetailDto> orderDetails;
    
}
