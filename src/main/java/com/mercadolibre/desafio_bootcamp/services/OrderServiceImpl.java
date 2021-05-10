package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.*;
import com.mercadolibre.desafio_bootcamp.repositories.*;
import com.mercadolibre.desafio_bootcamp.util.OrderMapper;
import com.mercadolibre.desafio_bootcamp.util.OrderStatusMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrdersService{

    private OrderRepository repoOrders;
    private ConcessioanrieRepository repoConcessionary;
    private DeliveryStatusRepository repoDeliveryStatus;
    private OrderMapper orderMapper;
    private OrderStatusMapper orderStatusMapper;


    public OrderServiceImpl(ConcessioanrieRepository repoConcessionary, DeliveryStatusRepository repoDeliveryStatus,
                            OrderRepository repoOrders, OrderMapper mapper, OrderStatusMapper orderStatusMapper){
        this.repoConcessionary = repoConcessionary;
        this.repoDeliveryStatus = repoDeliveryStatus;
        this.repoOrders = repoOrders;
        this.orderMapper = mapper;
        this.orderStatusMapper = orderStatusMapper;
    }


    public Integer validateOrder(Integer order){
        if (order < 1 || order > 2){
            throw new ApiException(HttpStatus.BAD_REQUEST.name(), "order must be between 1 or 2", HttpStatus.BAD_REQUEST.value());
        }
        return order;
    }

    private void orderOrders(Integer order, List<Order> orders) throws Exception {
        switch (order){
            case 1:
                orders.sort(Comparator.comparing(Order::getOrderNumberCM));
                break;

            case 2:
                orders.sort(Comparator.comparing(Order::getOrderNumberCM).reversed());
                break;
        }
    }

    @Transactional
    @Override
    public OrderResponseDto getOrders(Long dealerNumber, String deliveryStatusCode, Integer order) throws Exception {
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
        if(order > 0){
            validateOrder(order);
            orderOrders(order, orders);
        }
        List<OrderDto> orderDtos = orderMapper.mapList(orders);
        OrderResponseDto orderResponseDto = new OrderResponseDto(dealerNumber, orderDtos);
        return orderResponseDto;
    }

//    Validar largo strings
    @Transactional
    @Override
    public OrderStatusDto getOrderStatus(String code) {
        String[] res = code.split("-");
        validateCodes(res);
        Long dealerNumber = Long.parseLong(res[1]);
        Long numberCE = Long.parseLong(res[0]);
        Integer orderCode = Integer.parseInt(res[2]);
        List<Order> order = repoOrders.findOrderByConcessionarieIdEqualsAndCentralHouseIdEqualsAndOrderNumberCMEquals(dealerNumber, numberCE, orderCode);
        OrderStatusDto orderDtos = orderStatusMapper.mapList(order.get(0));
        return orderDtos;
    }

    private void validateCodes(String[] codes) {
        if (codes[0].length() != 4)
                throw new ApiException
                        (HttpStatus.UNPROCESSABLE_ENTITY.name(), "Central House code must have 4 digits", HttpStatus.UNPROCESSABLE_ENTITY.value());
        if (codes[1].length() != 4)
            throw new ApiException
                    (HttpStatus.UNPROCESSABLE_ENTITY.name(), "Dealer code must have 4 digits", HttpStatus.UNPROCESSABLE_ENTITY.value());
        if (codes[2].length() != 8)
            throw new ApiException
                    (HttpStatus.UNPROCESSABLE_ENTITY.name(), "Order code must have 8 digits", HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
