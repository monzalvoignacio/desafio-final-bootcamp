package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import com.mercadolibre.desafio_bootcamp.repositories.CentralHouseRepository;
import com.mercadolibre.desafio_bootcamp.repositories.ConcessioanrieRepository;
import com.mercadolibre.desafio_bootcamp.util.ConcessionarieMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConcessionariesServiceImpl implements ConcessionariesService {

    private ConcessioanrieRepository concessioanrieRepository;
    private CentralHouseRepository centralHouseRepository;
    private ConcessionarieMapper concessionarieMapper;

    public ConcessionariesServiceImpl(CentralHouseRepository centralHouseRepository, ConcessioanrieRepository concessioanrieRepository, ConcessionarieMapper concessionarieMapper) {
        this.centralHouseRepository = centralHouseRepository;
        this.concessioanrieRepository = concessioanrieRepository;
        this.concessionarieMapper = concessionarieMapper;
    }

    @Override
    @Transactional
    public ConcessionarieDto createConcessionarie(ConcessionarieDto concessionarieDto, String centralHouseId) {
        Long LCentralHouseId = Long.parseLong(centralHouseId);
        CentralHouse centralHouse = centralHouseRepository.findById(LCentralHouseId).orElse(null);
        if(centralHouse == null)
            throw new ApiException(HttpStatus.NOT_FOUND.name(), "Can't find central house", HttpStatus.NOT_FOUND.value());
        validatePhoneAndName(concessionarieDto.getName(), Integer.parseInt(concessionarieDto.getPhone()));
        Concessionarie newConcessionarie = new Concessionarie();
        newConcessionarie.setAddress(concessionarieDto.getAddress());
        newConcessionarie.setCountry(concessionarieDto.getCountry());
        newConcessionarie.setName(concessionarieDto.getName());
        newConcessionarie.setPhone(Integer.parseInt(concessionarieDto.getPhone()));
        newConcessionarie.setCentralHouse(centralHouse);
        concessioanrieRepository.save(newConcessionarie);
        return concessionarieMapper.map(newConcessionarie);
    }

    @Override
    @Transactional
    public ConcessionarieDto updateConcessionarie(ConcessionarieDto newConcessionarie) {
        if(newConcessionarie.getId() == null) {
            throw new ApiException(HttpStatus.UNPROCESSABLE_ENTITY.name(), "Id must be present", HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
        Concessionarie concessionarie = concessioanrieRepository.findById(newConcessionarie.getId()).orElse(null);
        if(concessionarie == null) {
            throw new ApiException(HttpStatus.NOT_FOUND.name(), "Can't find concessionarie", HttpStatus.NOT_FOUND.value());
        }
        validatePhoneAndName(newConcessionarie.getName(), Integer.parseInt(newConcessionarie.getPhone()));
        concessionarie.setAddress(newConcessionarie.getAddress());
        concessionarie.setCountry(newConcessionarie.getCountry());
        concessionarie.setName(newConcessionarie.getName());
        concessionarie.setPhone(Integer.parseInt(newConcessionarie.getPhone()));
        concessioanrieRepository.save(concessionarie);
        return concessionarieMapper.map(concessionarie);
    }

    @Override
    public void deleteConcessionarie(String id) {
        Long Lid = Long.parseLong(id);
        concessioanrieRepository.deleteById(Lid);
    }

    @Override
    public List<ConcessionarieDto> getConcessionaries(String centralHouseId) {
        if(centralHouseId.equals(""))
            throw new ApiException(HttpStatus.UNPROCESSABLE_ENTITY.name(), "Central house id can't be empty", HttpStatus.BAD_REQUEST.value());
        Long LCentralHouseId = Long.parseLong(centralHouseId);
        CentralHouse centralHouse = centralHouseRepository.findById(LCentralHouseId).orElse(null);
        if(centralHouse == null)
            throw new ApiException(HttpStatus.NOT_FOUND.name(), "Can't find central house", HttpStatus.NOT_FOUND.value());
        List<Concessionarie> concessionaries = concessioanrieRepository.findByCentralHouseIdEquals(LCentralHouseId);

        return concessionarieMapper.mapList(concessionaries);
    }

    private void validatePhoneAndName(String name, Integer phone) {
        if(!concessioanrieRepository.findByNameEquals(name).isEmpty()) {
            throw new ApiException(HttpStatus.UNPROCESSABLE_ENTITY.name(), "Name already exists for this centralhouse", HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
        if(!concessioanrieRepository.findByPhoneEquals(phone).isEmpty()) {
            throw new ApiException(HttpStatus.UNPROCESSABLE_ENTITY.name(), "Phone already exists for this centralhouse", HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
    }
}
