package com.mercadolibre.desafio_bootcamp.util;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcessionarieMapper {
    public List<ConcessionarieDto> mapList(List<Concessionarie> concesionaries) {
        List<ConcessionarieDto> list = new ArrayList<>();
        for(Concessionarie o : concesionaries) {
            list.add(map(o));
        }
        return list;
    }

    public ConcessionarieDto map(Concessionarie concesionarie){
        ConcessionarieDto concessionarieDto = new ConcessionarieDto();
        concessionarieDto.setName(concesionarie.getName());
        concessionarieDto.setAddress(concesionarie.getAddress());
        concessionarieDto.setId(concesionarie.getId());
        concessionarieDto.setPhone(String.valueOf(concesionarie.getPhone()));
        concessionarieDto.setCountry(concesionarie.getCountry());
        return concessionarieDto;
    }
}
