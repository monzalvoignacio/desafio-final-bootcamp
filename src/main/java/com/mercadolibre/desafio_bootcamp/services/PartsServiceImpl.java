package com.mercadolibre.desafio_bootcamp.services;

import com.google.common.reflect.TypeToken;
import com.google.protobuf.Api;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.exceptions.ApiException;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;
import com.mercadolibre.desafio_bootcamp.repositories.PartRecordRepository;
import com.mercadolibre.desafio_bootcamp.repositories.PartRepository;
import com.mercadolibre.desafio_bootcamp.util.DateMapper;
import com.mercadolibre.desafio_bootcamp.util.PartMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PartsServiceImpl implements PartsService{

    private PartRepository repoParts;
    private PartRecordRepository repoPartRecords;
    private PartMapper mapper;

    public PartsServiceImpl(PartRepository repoParts, PartRecordRepository repoPartRecords, PartMapper mapper){
        this.repoParts = repoParts;
        this.repoPartRecords = repoPartRecords;
        this.mapper = mapper;
    }

    @Override
    public PartResponseDto getParts(String queryType, String date, String order) throws Exception {
        // Se valida el queryType, en caso de ser C no debemos validar fechas ni nada por el estilo, solo arrojamos una excepción pq son filtros que no deben incluirse
        // Caso contrario se debe mappear la fecha, dónde se valida también que el formato sea correcto yyyy-MM-dd
        LocalDate fecha = null;
        Integer orderInt = null;
        if (!queryType.equals("C")){
            fecha = DateMapper.mappearFecha(date);
            orderInt = validateOrder(order);
        }
        else{
            if (!date.isEmpty() || !order.isEmpty()){
                throw new ApiException(HttpStatus.BAD_REQUEST.name(), "No filters allow with queryType C", HttpStatus.BAD_REQUEST.value());
            }
        }
        List<PartDto> listParts = new ArrayList<>();
        // Dependiendo el queryType indicado (por defceto C) obtenemos los datos
        switch (queryType){
            case "C":
                listParts = getAllParts();
                break;
            case "P":
                listParts = getAllPartsModify(fecha, orderInt);
                break;
            case "V":
                listParts = getAllPartsPriceMod(fecha,orderInt);
                break;
        }

        if(listParts != null && listParts.isEmpty())
        {
            throw new ApiException(HttpStatus.NOT_FOUND.name(),"404 Not Found", HttpStatus.NOT_FOUND.value());
        }

        return new PartResponseDto(listParts);
    }

    public Integer validateOrder(String order){
        Integer orderInt = null;
        try {
            orderInt = Integer.parseInt(order);
        }
        catch (Exception ex){
            throw new ApiException(HttpStatus.BAD_REQUEST.name(), "invalid order format", HttpStatus.BAD_REQUEST.value());
        }
        if (orderInt < 1 || orderInt > 3){
            throw new ApiException(HttpStatus.BAD_REQUEST.name(), "order must be between 1 or 3", HttpStatus.BAD_REQUEST.value());
        }
        return orderInt;
    }

    public List<PartDto> getAllParts(){
        var result =  this.repoParts.findAll();
        ArrayList<PartDto> parts = new ArrayList<>();
        return mapper.mapList(result, false);
    }

    public List<PartDto> getAllPartsPriceMod(LocalDate date, Integer order) throws Exception {
        List<PartRecord> result = this.repoPartRecords.findByLastModificationAfter(date);
        if (order > 0){
            orderPartsRecords(order, result);
        }
        List<Part> parts = getRelatedParts(result);
        return mapper.mapList(parts, true);
    }

    public List<Part> getRelatedParts(List<PartRecord> records) {
        List<Part> parts = new ArrayList<>();
        for(PartRecord p: records){
            parts.add(p.getPart());
        }
        return parts;
    }

    public List<PartDto> getAllPartsModify(LocalDate date, Integer order) throws Exception {
        List<Part> result = this.repoParts.findByLastModificationAfter(date);
        if(order > 0){
            orderParts(order, result);
        }
        return mapper.mapList(result, false);
    }

    // order a list of Parts
    public void orderParts(Integer order, List<Part> parts) throws Exception {
        switch (order){
            case 1:
                parts.sort(Comparator.comparing(Part::getDescription));
                break;
            case 2:
                parts.sort(Comparator.comparing(Part::getDescription).reversed());
                break;
            case 3:
                parts.sort(Comparator.comparing(Part::getLastModification));
                break;
        }
    }

    // order a list of PartsRecords
    public void orderPartsRecords(Integer order, List<PartRecord> parts) throws Exception {
        switch (order){
            case 1:
                parts.sort((p1, p2) -> p1.getPart().getDescription().compareTo(p2.getPart().getDescription()));
                break;
            case 2:
                parts.sort((p1, p2) -> p2.getPart().getDescription().compareTo(p1.getPart().getDescription()));
                break;
            case 3:
                parts.sort(Comparator.comparing(PartRecord::getLastModification));
        }
    }
}
