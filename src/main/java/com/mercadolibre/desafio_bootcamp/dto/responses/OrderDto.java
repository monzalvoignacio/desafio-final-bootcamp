package com.mercadolibre.desafio_bootcamp.dto.responses;

import com.mercadolibre.desafio_bootcamp.models.DeliveryStatus;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
public class OrderDto {
    private Integer orderNumber;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Integer daysDelayed;
    private String deliveryStatus;
    private List<OrderDetailDto> orderDetails;
    
}
