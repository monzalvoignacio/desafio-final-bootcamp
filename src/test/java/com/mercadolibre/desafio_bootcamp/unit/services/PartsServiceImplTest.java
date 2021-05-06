package com.mercadolibre.desafio_bootcamp.unit.services;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;
import com.mercadolibre.desafio_bootcamp.repositories.PartRecordRepository;
import com.mercadolibre.desafio_bootcamp.repositories.PartRepository;
import com.mercadolibre.desafio_bootcamp.services.PartsServiceImpl;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
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
    @DisplayName("Main service method successful")
    void getParts1() throws Exception {
        Mockito.when(partRepositoryMock.findAll()).thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any())).thenReturn(PartsFixture.defaultListPartDto());
        PartResponseDto expected = PartsFixture.defaultPartResponseDto();
        PartResponseDto actual = service.getParts("C", "", "");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exception no filters allowed with type C")
    void getParts2() {
        Exception e = assertThrows(ApiException.class,
                () -> service.getParts("C", "", "2"));
        assertEquals("No filters allow with queryType C", e.getMessage());
    }

    @Test
    @DisplayName("Exception invalid date format")
    void getParts3() {
        Exception e = assertThrows(ApiException.class,
                () -> service.getParts("P", "27/02/2001", "0"));
        assertEquals("Date mapping error. Should be yyyy-MM-dd", e.getMessage());
    }

    @Test
    @DisplayName("Exception invalid date format")
    void getParts4() {
        Mockito.when(partRepositoryMock.findAll())
                .thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any()))
                .thenReturn(new ArrayList<>());
        Exception e = assertThrows(ApiException.class,
                () -> service.getParts("C", "", ""));
        assertEquals("404 Not Found", e.getMessage());
    }

    @Test
    @DisplayName("Query type C")
    void validateQueryType1() throws Exception {
        Mockito.when(partRepositoryMock.findAll()).thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any())).thenReturn(PartsFixture.defaultListPartDto());
        List<PartDto> expected = PartsFixture.defaultListPartDto();
        List<PartDto> actual = service.queryParts("C", null, 0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Query type P")
    void validateQueryType2() throws Exception {
        Mockito.when(partRepositoryMock.findByLastModificationAfter(Mockito.any()))
                .thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when((mapperMock.mapList(Mockito.any(), Mockito.any())))
                .thenReturn(PartsFixture.defaultListPartDto());
        List<PartDto> expected = PartsFixture.defaultListPartDto();
        List<PartDto> actual = service.queryParts("P", LocalDate.of(2014,01,10), 0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Query type V")
    void validateQueryType3() throws Exception {
        Mockito.when(partRecordRepositoryMock.findByLastModificationAfter(Mockito.any()))
                .thenReturn(PartsFixture.defaultListPartRecord());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any())).thenReturn(PartsFixture.defaultListPartDtoPriceModification());
        List<PartDto> expected = PartsFixture.defaultListPartDtoPriceModification();
        List<PartDto> actual = service.queryParts("V", LocalDate.of(2014,01,10), 0);
        assertEquals(expected, actual);
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
    @DisplayName("Get modified price parts")
    void getPriceModifiedParts() throws Exception {
        Mockito.when(partRecordRepositoryMock.findByLastModificationAfter(Mockito.any()))
                .thenReturn(PartsFixture.defaultListPartRecord());
        Mockito.when(mapperMock.mapList(Mockito.any(), Mockito.any())).thenReturn(PartsFixture.defaultListPartDtoPriceModification());
        List<PartDto> expected = PartsFixture.defaultListPartDtoPriceModification();
        assertEquals(4, partRecordRepositoryMock.findByLastModificationAfter(LocalDate.of(2013, 04, 05)).size());
        assertEquals(expected, service.getAllPartsPriceMod(LocalDate.of(2014,01,10), 0));
    }

    @Test
    @DisplayName("Get modified parts")
    void getModifiedParts() throws Exception {
        Mockito.when(partRepositoryMock.findByLastModificationAfter(Mockito.any()))
                .thenReturn(PartsFixture.defaultListPartModel());
        Mockito.when((mapperMock.mapList(Mockito.any(), Mockito.any()))).thenReturn(PartsFixture.defaultListPartDto());
        List<PartDto> expected = PartsFixture.defaultListPartDto();
        assertEquals(4, partRepositoryMock.findByLastModificationAfter(LocalDate.of(2016, 07, 11)).size());
        assertEquals(expected, service.getAllPartsModify(LocalDate.of(2014,01,10), 0));
    }

    @Test
    @DisplayName("Get related parts")
    void getRelatedParts() {
        List<PartRecord> records = PartsFixture.defaultListPartRecord();
        List<Part> expected = PartsFixture.defaultListPartModel();
        List<Part> actual = service.getRelatedParts(records);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get ordered list by description")
    void orderByDescription() throws Exception {
        List<Part> expected = PartsFixture.defaultOrderedListPartDescription();
        List<Part> actual = PartsFixture.defaultListPartModel();
        service.orderParts(1, actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get reversed ordered list by description")
    void orderByDescriptionReversed() throws Exception {
        List<Part> expected = PartsFixture.defaultOrderedListPartDescriptionReversed();
        List<Part> actual = PartsFixture.defaultListPartModel();
        service.orderParts(2, actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get ordered list by last modification")
    void orderByPartModification() throws Exception {
        List<Part> expected = PartsFixture.defaultOrderedListPartLastModification();
        List<Part> actual = PartsFixture.defaultListPartModel();
        service.orderParts(3, actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get ordered list by description")
    void orderByDescription2() throws Exception {
        List<PartRecord> expected = PartsFixture.defaultOrderedListPartRecordDescription();
        List<PartRecord> actual = PartsFixture.defaultListPartRecord();
        service.orderPartsRecords(1, actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get reversed ordered list by description")
    void orderByDescriptionReversed2() throws Exception {
        List<PartRecord> expected = PartsFixture.defaultOrderedListPartRecordDescriptionReverse();
        List<PartRecord> actual = PartsFixture.defaultListPartRecord();
        service.orderPartsRecords(2, actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get ordered list by last price modification")
    void orderByPartModification2() throws Exception {
        List<PartRecord> expected = PartsFixture.defaultOrderedListPartRecordPrice();
        List<PartRecord> actual = PartsFixture.defaultListPartRecord();
        service.orderPartsRecords(3, actual);
        assertEquals(expected, actual);
    }

}