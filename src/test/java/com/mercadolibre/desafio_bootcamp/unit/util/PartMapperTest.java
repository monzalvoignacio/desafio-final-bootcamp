package com.mercadolibre.desafio_bootcamp.unit.util;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.unit.fixtures.PartsFixture;
import com.mercadolibre.desafio_bootcamp.util.MockitoExtension;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PartMapperTest {

    private PartMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new PartMapper();
    }

    @Test
    @DisplayName("Map single object")
    void mapObject() {
        PartDto expected = PartsFixture.defaultPartDto();
        PartDto actual = mapper.map(PartsFixture.defaultPart1(), false);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Map list")
    void mapList() {
        List<PartDto> expected = PartsFixture.defaultListPartDto();
        List<PartDto> actual = mapper.mapList(PartsFixture.defaultListPartModel(), false);
        assertEquals(expected, actual);
    }

}