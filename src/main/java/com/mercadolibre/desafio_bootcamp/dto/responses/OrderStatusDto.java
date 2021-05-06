package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.dto.OrderDetailDto;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {
    private String orderNumberCE;
    private String orderDate;
    private String orderStatus;
    private List<OrderDetailDto> orderDetails;

}
