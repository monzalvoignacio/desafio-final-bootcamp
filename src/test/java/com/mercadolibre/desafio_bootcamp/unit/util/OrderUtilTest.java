package com.mercadolibre.desafio_bootcamp.unit.util;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.Order;
import com.mercadolibre.desafio_bootcamp.repositories.PartRepository;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.OrderFixture;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.OrderUtil;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderUtilTest {

    private OrderUtil orderUtil;
    private PartRepository repoPartsMock;

    @BeforeEach
    void setUp() {
        repoPartsMock = Mockito.mock(PartRepository.class);
        orderUtil = new OrderUtil(repoPartsMock);
    }

    @Test
    @DisplayName("Generate order")
    void generateOrder() {
        Order expected = OrderFixture.defaultOrder();
        Order actual = orderUtil.generateOrder(OrderFixture.defaultConcessionarie(),
                OrderFixture.defaultShippingType(), OrderFixture.defaultCentralHouse(),
                OrderFixture.defaultDeliveryStatus(), 3);
        assertEquals(expected, actual);
    }




}