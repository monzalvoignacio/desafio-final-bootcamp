package com.mercadolibre.desafio_bootcamp.unit.util;

import com.mercadolibre.desafio_bootcamp.dto.OrderDetailDto;
import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderResponseDto;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.OrderFixture;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OrderMapperTest {

    private OrderMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new OrderMapper();
    }

    @Test
    @DisplayName("Map single object")
    void mapSingleOrder() {
        OrderDto expected = OrderFixture.defaultOrderDto1();
        OrderDto actual = mapper.map(OrderFixture.defaultOrder1());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Map an order detail list to dto")
    void mapOrderDetailList() {
        List<OrderDetailDto> expected = OrderFixture.defaultOrderDetailDtoList();
        List<OrderDetailDto> actual = mapper.mapOrderDetails(OrderFixture.defaultOrderDetailList());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Map an order list to dto")
    void mapOrderList() {
        List<OrderDto> expected = OrderFixture.defaultOrderDtoList();
        List<OrderDto> actual = mapper.mapList(OrderFixture.defaultOrderList());
        assertEquals(expected, actual);
    }

}