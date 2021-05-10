package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.OrderRequestDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.BasicResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.GenerateOrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;
import org.springframework.http.ResponseEntity;

public interface OrdersService {

    OrderResponseDto getOrders(Long dealerNumber, String deliveryStatusCode, Integer order) throws Exception;
    OrderStatusDto getOrderStatus(String code);
    GenerateOrderResponseDto generateOrder(OrderRequestDto request);
    BasicResponseDto updateOrderStatus(Integer orderNumberCM, String orderStatus);

}
