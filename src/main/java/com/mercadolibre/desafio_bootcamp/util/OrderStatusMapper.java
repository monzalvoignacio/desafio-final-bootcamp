package com.mercadolibre.desafio_bootcamp.util;

import com.mercadolibre.desafio_bootcamp.dto.OrderDetailDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;
import com.mercadolibre.desafio_bootcamp.models.Order;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderStatusMapper {

    public OrderStatusDto mapList(Order order) {
        return map(order);
    }

    public List<OrderDetailDto>  mapOrderDetails(List<OrderDetail> orderDetails){
        List<OrderDetailDto> response = new ArrayList<>();
        for(OrderDetail od : orderDetails){
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setDescription(od.getDescription());
            orderDetailDto.setQuantity(od.getQuantity());
            orderDetailDto.setPartCode(od.getPart().getPartCode());
            orderDetailDto.setReason(od.getReason());
            orderDetailDto.setAccountType(od.getAccountType().getName());
            response.add(orderDetailDto);
        }
        return response;
    }

    public OrderStatusDto map(Order order){
        OrderStatusDto orderDto = new OrderStatusDto();
        orderDto.setOrderNumberCE(
                intToCodeString(4,
                        String.valueOf(order.getConcessionarie().getId()))
                        + "-"
                        + intToCodeString(8, String.valueOf(order.getOrderNumberCM())));
        orderDto.setOrderDate(order.getOrderDate().toString());
        orderDto.setOrderStatus(order.getDeliveryStatus().getCode());
        orderDto.setOrderDetails(mapOrderDetails(order.getOrderDetails()));
        return orderDto;
    }

    private String intToCodeString(int len, String aux) {
        String res = "";
        for (int j = 0; j < len - aux.length(); j++) {
            res = res + "0";
        }
        return res + aux;
    }
}
