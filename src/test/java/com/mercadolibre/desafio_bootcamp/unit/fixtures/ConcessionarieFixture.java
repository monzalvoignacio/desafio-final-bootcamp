package com.mercadolibre.desafio_bootcamp.unit.fixtures;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import com.mercadolibre.desafio_bootcamp.models.Order;

import java.util.ArrayList;
import java.util.List;

public class ConcessionarieFixture {

    public static List<Concessionarie> defaultConcessionariesList() {
        Concessionarie concessionarie = new Concessionarie();
        concessionarie.setPhone(1234567);
        concessionarie.setAddress("Av Italia 2713");
        concessionarie.setName("Name");
        concessionarie.setCountry("Uruguay");
        CentralHouse centralHouse = new CentralHouse();
        centralHouse.setId(1L);
        centralHouse.setCountry("Argentina");
        centralHouse.setPhone(1231232);
        centralHouse.setName("vofi");
        centralHouse.setAddress("Ambrosio Olmos 878");
        concessionarie.setCentralHouse(centralHouse);
        List<Concessionarie> res = new ArrayList<Concessionarie>();
        res.add(concessionarie);
        return res;
    }

    public static List<ConcessionarieDto> defaultConcessionariesListDtos() {
        ConcessionarieDto concessionarie = new ConcessionarieDto();
        concessionarie.setPhone("1234567");
        concessionarie.setAddress("Av Italia 2713");
        concessionarie.setName("Name");
        concessionarie.setCountry("Uruguay");
        List<ConcessionarieDto> res = new ArrayList<ConcessionarieDto>();
        res.add(concessionarie);
        return res;
    }

    public static Concessionarie defaultConcessionarie() {
        Concessionarie concessionarie = new Concessionarie();
        concessionarie.setPhone(1234567);
        concessionarie.setAddress("Av Italia 2713");
        concessionarie.setName("Name");
        concessionarie.setCountry("Uruguay");
        CentralHouse centralHouse = new CentralHouse();
        centralHouse.setId(1L);
        centralHouse.setCountry("Argentina");
        centralHouse.setPhone(1231232);
        centralHouse.setName("vofi");
        centralHouse.setAddress("Ambrosio Olmos 878");
        concessionarie.setCentralHouse(centralHouse);
        return concessionarie;
    }

    public static ConcessionarieDto defaultConcessionarieDto() {
        ConcessionarieDto concessionarie = new ConcessionarieDto();
        concessionarie.setPhone("1234567");
        concessionarie.setAddress("Av Italia 2713");
        concessionarie.setName("Name");
        concessionarie.setCountry("Uruguay");
        return concessionarie;
    }
}
