package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.OrderRequestDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.*;
import com.mercadolibre.desafio_bootcamp.services.OrdersService;
import com.mercadolibre.desafio_bootcamp.services.PartsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parts/orders")
public class OrdersController {
    private OrdersService service;

    public OrdersController(OrdersService oservice){
        service = oservice;
    }

    @GetMapping("/list")
    public ResponseEntity<OrderResponseDto> getOrders(@RequestParam(name = "dealerNumber",required = true) Long dealerNumber,
                                                     @RequestParam(name = "deliveryStatus", defaultValue = "",required = false) String deliveryStatus,
                                                     @RequestParam(name = "order", defaultValue = "0" ,required = false) Integer order) throws Exception {
        return new ResponseEntity<>(service.getOrders(dealerNumber,deliveryStatus,order), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderStatusDto> getOrder(@PathVariable String orderId) {
        OrderStatusDto o = service.getOrderStatus(orderId);
        return ResponseEntity.ok().body(o);
    }

    @PostMapping
    public ResponseEntity<GenerateOrderResponseDto> generateOrder(@RequestBody OrderRequestDto req)
    {
        ResponseEntity<GenerateOrderResponseDto> resp = new ResponseEntity<GenerateOrderResponseDto>(service.generateOrder(req), HttpStatus.CREATED);
        return resp;
    }

    @PatchMapping("/update_status")
    public BasicResponseDto udpadteOrderStatus(@RequestParam(name = "orderStatus", required = true) String orderStatus,
                                               @RequestParam(name = "orderNumberCM") Integer orderNumberCM){
        return service.updateOrderStatus(orderNumberCM,orderStatus);
    }
}
