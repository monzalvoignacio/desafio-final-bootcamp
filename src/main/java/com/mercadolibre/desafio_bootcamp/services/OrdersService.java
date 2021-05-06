package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;

public interface OrdersService {

    OrderResponseDto getOrders(Long dealerNumber, String deliveryStatusCode, Integer order) throws Exception;
    OrderStatusDto getOrderStatus(String code);
}
