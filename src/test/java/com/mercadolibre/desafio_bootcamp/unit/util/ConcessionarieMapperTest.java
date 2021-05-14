package com.mercadolibre.desafio_bootcamp.unit.util;

import com.mercadolibre.desafio_bootcamp.dto.OrderDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.ConcessionarieFixture;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.OrderFixture;
import com.mercadolibre.desafio_bootcamp.util.ConcessionarieMapper;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.OrderMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ConcessionarieMapperTest {
    private ConcessionarieMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ConcessionarieMapper();
    }

    @Test
    @DisplayName("Map single object")
    void mapSingleConcessionarie() {
        ConcessionarieDto expected = ConcessionarieFixture.defaultConcessionarieDto();
        ConcessionarieDto actual = mapper.map(ConcessionarieFixture.defaultConcessionarie());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Map single object")
    void mapSingleConcessionarieList() {
        List<ConcessionarieDto> expected = ConcessionarieFixture.defaultConcessionariesListDtos();
        List<ConcessionarieDto> actual = mapper.mapList(ConcessionarieFixture.defaultConcessionariesList());
        assertEquals(expected, actual);
    }
}
