package com.mercadolibre.desafio_bootcamp.unit.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.OrderStatusDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import com.mercadolibre.desafio_bootcamp.repositories.*;
import com.mercadolibre.desafio_bootcamp.services.ConcessionariesServiceImpl;
import com.mercadolibre.desafio_bootcamp.services.OrderServiceImpl;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.ConcessionarieFixture;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.OrderFixture;
import com.mercadolibre.desafio_bootcamp.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ConcessionariesServiceImplTest {
    private ConcessioanrieRepository concessioanrieRepositoryMock;
    private CentralHouseRepository centralHouseRepositoryMock;
    private ConcessionarieMapper concessionarieMapperMock;

    private ConcessionariesServiceImpl service;


    @BeforeEach
    void setUp() {
        concessioanrieRepositoryMock = Mockito.mock(ConcessioanrieRepository.class);
        centralHouseRepositoryMock = Mockito.mock(CentralHouseRepository.class);
        concessionarieMapperMock = Mockito.mock(ConcessionarieMapper.class);

        service = new ConcessionariesServiceImpl(centralHouseRepositoryMock, concessioanrieRepositoryMock, concessionarieMapperMock);
    }

    @Test
    @DisplayName("Main service method successful")
    void createConcessionarie() throws Exception {
        Mockito.when(concessioanrieRepositoryMock.save(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarie());
        Mockito.when(concessioanrieRepositoryMock.findByNameEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessioanrieRepositoryMock.findByPhoneEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessionarieMapperMock.map(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarieDto());
        Mockito.when(centralHouseRepositoryMock.findById(Mockito.any()))
                .thenReturn(Optional.of(new CentralHouse()));
        ConcessionarieDto expected = ConcessionarieFixture.defaultConcessionarieDto();
        ConcessionarieDto actual = service.createConcessionarie(ConcessionarieFixture.defaultConcessionarieDto(), "1");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Name exists exceptions test")
    void nameExistsExceptionsTest() throws Exception{
        Mockito.when(concessioanrieRepositoryMock.save(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarie());
        Mockito.when(concessioanrieRepositoryMock.findByNameEquals(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionariesList());
        Mockito.when(concessioanrieRepositoryMock.findByPhoneEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessionarieMapperMock.map(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarieDto());
        Mockito.when(centralHouseRepositoryMock.findById(Mockito.any()))
                .thenReturn(Optional.of(new CentralHouse()));
        assertThrows(ApiException.class, () -> service.createConcessionarie(ConcessionarieFixture.defaultConcessionarieDto(), "1"));
    }

    @Test
    @DisplayName("Phone exists exceptions test")
    void phoneExistsExceptionsTest() throws Exception{
        Mockito.when(concessioanrieRepositoryMock.save(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarie());
        Mockito.when(concessioanrieRepositoryMock.findByNameEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessioanrieRepositoryMock.findByPhoneEquals(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionariesList());
        Mockito.when(concessionarieMapperMock.map(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarieDto());
        Mockito.when(centralHouseRepositoryMock.findById(Mockito.any()))
                .thenReturn(Optional.of(new CentralHouse()));
        assertThrows(ApiException.class, () -> service.createConcessionarie(ConcessionarieFixture.defaultConcessionarieDto(), "1"));
    }

    @Test
    @DisplayName("Get all concessionaries")
    void getConcessionaries() throws Exception {
        Mockito.when(concessioanrieRepositoryMock.save(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarie());
        Mockito.when(concessioanrieRepositoryMock.findByNameEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessioanrieRepositoryMock.findByPhoneEquals(Mockito.any())).thenReturn(new ArrayList<Concessionarie>());
        Mockito.when(concessionarieMapperMock.map(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionarieDto());
        Mockito.when(concessionarieMapperMock.mapList(Mockito.any())).thenReturn(ConcessionarieFixture.defaultConcessionariesListDtos());
        Mockito.when(centralHouseRepositoryMock.findById(Mockito.any()))
                .thenReturn(Optional.of(new CentralHouse()));
        List<ConcessionarieDto> expected = new ArrayList<ConcessionarieDto>();
        expected.add(ConcessionarieFixture.defaultConcessionarieDto());
        List<ConcessionarieDto> actual = service.getConcessionaries("1");
        assertEquals(expected, actual);
    }
}
