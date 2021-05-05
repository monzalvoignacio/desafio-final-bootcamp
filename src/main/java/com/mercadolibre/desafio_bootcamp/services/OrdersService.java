package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;

public interface OrdersService {

    OrderResponseDto getOrders(Long dealerNumber, char deliveryStatusCode, String order) throws Exception;
}
