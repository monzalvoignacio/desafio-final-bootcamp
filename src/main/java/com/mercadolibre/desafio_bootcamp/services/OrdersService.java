package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;

public interface OrdersService {

    OrderResponseDto getOrders(Long dealerNumber, String deliveryStatusCode, String order) throws Exception;
}
