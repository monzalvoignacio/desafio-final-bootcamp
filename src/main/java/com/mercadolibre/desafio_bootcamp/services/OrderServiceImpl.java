package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.*;
import com.mercadolibre.desafio_bootcamp.repositories.*;
import com.mercadolibre.desafio_bootcamp.util.DateMapper;
import com.mercadolibre.desafio_bootcamp.util.OrderMapper;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService{

    private OrderRepository repoOrders;
    private ConcessioanrieRepository repoConcessionary;
    private DeliveryStatusRepository repoDeliveryStatus;
    private OrderMapper orderMapper;


    public OrderServiceImpl(ConcessioanrieRepository repoConcessionary, DeliveryStatusRepository repoDeliveryStatus,
                                OrderRepository repoOrders, OrderMapper mapper){
        this.repoConcessionary = repoConcessionary;
        this.repoDeliveryStatus = repoDeliveryStatus;
        this.repoOrders = repoOrders;
        this.orderMapper = mapper;
    }


    @Override
    public OrderResponseDto getOrders(Long dealerNumber, String deliveryStatusCode, String order) throws Exception {
        List<Order> orders = null;
        boolean filterStatusCode = !deliveryStatusCode.isEmpty();

        Concessionarie consessionary = repoConcessionary.findById(dealerNumber).orElse(null);
        if(consessionary == null){
            throw new ApiException
                    (HttpStatus.BAD_REQUEST.name(), "Concessionary not found", HttpStatus.BAD_REQUEST.value());
        }

        if (filterStatusCode){
            DeliveryStatus deliveryStatus = repoDeliveryStatus.findByCodeEquals(deliveryStatusCode)
                    .stream().findFirst().orElse(null);
            if (deliveryStatus == null){
                throw new ApiException
                        (HttpStatus.BAD_REQUEST.name(),
                                "No such delivery status found", HttpStatus.BAD_REQUEST.value());
            }

            orders = repoOrders.
                    findOrderByConcessionarieIdEqualsAndDeliveryStatusIdEquals(dealerNumber,deliveryStatus.getId());
        }
        else{
            orders = repoOrders.findOrderByConcessionarieIdEquals(dealerNumber);
        }


        if (orders.size() == 0){
            throw new ApiException
                    (HttpStatus.BAD_REQUEST.name(), "No orders found for this concessionaire", HttpStatus.BAD_REQUEST.value());
        }
        List<OrderDto> orderDtos = orderMapper.mapList(orders);
        OrderResponseDto orderResponseDto = new OrderResponseDto(dealerNumber, orderDtos);
        return orderResponseDto;
    }

}
