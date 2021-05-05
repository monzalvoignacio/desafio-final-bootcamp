package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.services.OrdersService;
import com.mercadolibre.desafio_bootcamp.services.PartsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
    private OrdersService service;

    public OrdersController(OrdersService oservice){
        service = oservice;
    }

    @GetMapping("/list")
    public ResponseEntity<OrderResponseDto> getOrders(@RequestParam(name = "dealerNumber",required = true) Long dealerNumber,
                                                     @RequestParam(name = "deliveryStatus", defaultValue = "",required = false) String deliveryStatus,
                                                     @RequestParam(name = "order", defaultValue = "" ,required = false) String order) throws Exception {
        return new ResponseEntity<>(service.getOrders(dealerNumber,deliveryStatus,order), HttpStatus.OK);
    }
}
