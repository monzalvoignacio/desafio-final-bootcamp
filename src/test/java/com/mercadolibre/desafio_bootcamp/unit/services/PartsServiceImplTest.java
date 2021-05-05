package com.mercadolibre.desafio_bootcamp.unit.services;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.repositories.PartRecordRepository;
import com.mercadolibre.desafio_bootcamp.repositories.PartRepository;
import com.mercadolibre.desafio_bootcamp.services.PartsServiceImpl;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)  // CHECKEAR SI NO DEBERIAMOS USAR LA CLASE CONFIGURADA DE MELI
class PartsServiceImplTest {

    private PartsServiceImpl service;
    private PartRepository partRepositoryMock;
    private PartRecordRepository partRecordRepositoryMock;
    private PartMapper mapperMock;

    @BeforeEach
    void setUp() {
        partRepositoryMock = Mockito.mock(PartRepository.class);
        partRecordRepositoryMock = Mockito.mock(PartRecordRepository.class);
        mapperMock = Mockito.mock(PartMapper.class);
        service = new PartsServiceImpl(partRepositoryMock, partRecordRepositoryMock, mapperMock);
    }

    @Test
    @DisplayName("First Test")
    void sum() {
        assertEquals(2, 1+1);
    }

    @Test
    @DisplayName("Valid order")
    void validateOrder() {
        assertEquals(2, service.validateOrder("2"));
    }

    @Test
    @DisplayName("Invalid order out of range")
    void validateOrder2() {
        Exception e = assertThrows(ApiException.class,
                () -> service.validateOrder("8"));
        assertEquals("order must be between 1 or 3", e.getMessage());
    }

    @Test
    @DisplayName("Invalid order format")
    void validateOrder3() {
        Exception e = assertThrows(ApiException.class,
                () -> service.validateOrder("m"));
        assertEquals("invalid order format", e.getMessage());
    }

    @Test
    @DisplayName("Get all parts")
    void getAllParts() {
        Mockito.when(partRepositoryMock.findAll()).thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any())).thenReturn(PartsFixture.defaultListPartDto());
        List<PartDto> expected = PartsFixture.defaultListPartDto();
        assertEquals(expected, service.getAllParts());
    }

    @Test
    @DisplayName("Get parts filtered by modification date")
    void getModifiedParts() throws Exception {
        Mockito.when(partRecordRepositoryMock.findByLastModificationAfter(Mockito.any()))
                .thenReturn(PartsFixture.defaultListPartRecord());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any()))
                .thenReturn(PartsFixture.defaultFilteredListPartDto1());
        List<PartDto> expected = PartsFixture.defaultFilteredListPartDto1();
        assertEquals(4, partRecordRepositoryMock.findByLastModificationAfter(Mockito.any()).size());
        assertEquals(expected, service.getAllPartsPriceMod(LocalDate.of(2014,01,10), 0));
    }


    /*
class HotelServiceImpleTest {


    @Test
    @DisplayName("List all available hotels")
    void listAllHotelsAvailable() throws HotelException {
        Mockito.when(repositoryMock.loadHotels(any())).thenReturn(HotelDTOFixture.defaultHotels());
        List<HotelFormatDTO> actual = service.listHotelsAvailable(new HashMap<>());
        List<HotelFormatDTO> expected = HotelDTOFixture.defaultAvailableHotels();
        assertEquals(expected, actual);
    }
     */
}