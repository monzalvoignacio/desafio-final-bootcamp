package com.mercadolibre.desafio_bootcamp.unit.services;


import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import com.mercadolibre.desafio_bootcamp.models.Order;
import com.mercadolibre.desafio_bootcamp.repositories.*;
import com.mercadolibre.desafio_bootcamp.services.OrderServiceImpl;
import com.mercadolibre.desafio_bootcamp.services.PartsServiceImpl;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.OrderFixture;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.OrderMapper;
import com.mercadolibre.desafio_bootcamp.util.OrderStatusMapper;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {
    private OrderServiceImpl service;
    private OrderRepository orderRepositoryMock;
    private OrderMapper orderMapperMock;
    private OrderStatusMapper orderStatusMapperMock;
    private ConcessioanrieRepository repoConcessionaryMock;
    private DeliveryStatusRepository repoDeliveryStatusMock;





    @BeforeEach
    void setUp() {
        orderRepositoryMock = Mockito.mock(OrderRepository.class);
        orderMapperMock = Mockito.mock(OrderMapper.class);
        orderStatusMapperMock = Mockito.mock(OrderStatusMapper.class);
        repoConcessionaryMock = Mockito.mock(ConcessioanrieRepository.class);
        repoDeliveryStatusMock = Mockito.mock(DeliveryStatusRepository.class);
        service = new OrderServiceImpl(repoConcessionaryMock, repoDeliveryStatusMock,
                orderRepositoryMock, orderMapperMock, orderStatusMapperMock);
    }

    @Test
    @DisplayName("Main service method successful")
    void getOrders1() throws Exception {
        Mockito.when(orderRepositoryMock.findOrderByConcessionarieIdEqualsAndCentralHouseIdEqualsAndOrderNumberCMEquals
                (Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(OrderFixture.defaultOrderList());

        Mockito.when(orderStatusMapperMock.mapList(Mockito.any())).thenReturn(OrderFixture.defaultOrderStatusDto1());
        OrderStatusDto expected = OrderFixture.defaultOrderStatusDto1();
        OrderStatusDto actual = service.getOrderStatus("0001-0001-00000001");
        assertEquals(expected, actual);
    }

    /*

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

     */

    @Test
    @DisplayName("Invalid code exceptions test")
    void invalidCodeExceptionsTest() throws Exception{
        String originalCode = "0001-001-00000001";
        assertThrows(ApiException.class, () -> service.getOrderStatus(originalCode));
    }

    @Test
    @DisplayName("Invalid central house code exceptions test")
    void invalidCentralHouseCodeExceptionsTest() throws Exception{
        String originalCode = "1-0001-00000001";
        Exception e = assertThrows(ApiException.class,
                () -> service.getOrderStatus(originalCode));
        assertEquals("Central House code must have 4 digits", e.getMessage());
    }

    @Test
    @DisplayName("Invalid dealer code exceptions test")
    void invalidDealerCodeExceptionsTest() throws Exception{
        String originalCode = "0001-2-00000001";
        Exception e = assertThrows(ApiException.class,
                () -> service.getOrderStatus(originalCode));
        assertEquals("Dealer code must have 4 digits", e.getMessage());
    }
    @Test
    @DisplayName("Invalid order code exceptions test")
    void invalidOrderCodeExceptionsTest() throws Exception{
        String originalCode = "0001-0001-0001";
        Exception e = assertThrows(ApiException.class,
                () -> service.getOrderStatus(originalCode));
        assertEquals("Order code must have 8 digits", e.getMessage());
    }

    @Test
    @DisplayName("Main service method successful")
    void invalidOrderThrowsException() throws Exception {
        String validCode = "0001-0001-00000001";
        Long validDealerNumber = 1L;
        Integer invalidOrder = 3;
        Order order = OrderFixture.defaultOrder1();
        Concessionarie concessionarie = order.getConcessionarie();
        List<Concessionarie> concessionaries = new ArrayList<>();
        concessionaries.add(concessionarie);
        Mockito.when(repoConcessionaryMock.findById(Mockito.any())).thenReturn(concessionaries.stream().findAny());
        Mockito.when(orderRepositoryMock.findOrderByConcessionarieIdEquals(order.getConcessionarie().getId())).
                thenReturn(OrderFixture.defaultOrderList());
        Exception e = assertThrows(ApiException.class,
                () -> service.getOrders(validDealerNumber,"",invalidOrder));
        assertEquals("order must be between 1 or 2", e.getMessage());
    }




    /*
    CustomException thrown = assertThrows(
                CustomException.class,
                () -> flightService.getSpecificFlight(search) ,
                "Expected doThing() to throw, but it didn't"
        );

        assertTrue(thrown.getTitle().contains("Destination Error"));

     */

}
