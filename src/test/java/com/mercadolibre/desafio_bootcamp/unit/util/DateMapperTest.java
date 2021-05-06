package com.mercadolibre.desafio_bootcamp.unit.util;

import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.util.DateMapper;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DateMapperTest {

    private DateMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new DateMapper();
    }

    @Test
    @DisplayName("Succesful date mapping")
    void mapDate() throws Exception {
        LocalDate expected = LocalDate.of(2020, 03, 19);
        LocalDate actual = mapper.mappearFecha("2020-03-19");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Invalid date format")
    void mapDateException() {
        ApiException e = assertThrows(ApiException.class,
                () -> mapper.mappearFecha("2020/03/19"));
        assertEquals("Date mapping error. Should be yyyy-MM-dd", e.getDescription());
    }

}