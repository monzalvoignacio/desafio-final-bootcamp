package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;

public interface OrdersService {

    OrderResponseDto getOrders(Integer dealerNumber, char deliveryStatus, String order) throws Exception;
}
