package com.mercadolibre.desafio_bootcamp.util;

import com.mercadolibre.desafio_bootcamp.dto.NewPartDto;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.*;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PartMapper {



    public List<PartDto> mapList(List<Part> parts, Boolean isPrice) {
        List<PartDto> list = new ArrayList<>();
        for(Part p : parts) {
            list.add(map(p, isPrice));
        }
        return list;
    }

    public Part reverseMap(NewPartDto newPart, Provider provider){
        Part part = new Part();
        part.setId(part.getId());
        part.setPartCode(part.getPartCode());
        part.setDescription(part.getDescription());
        part.setProvider(provider);
        part.setStock(part.getStock());
        part.setNetWeight(part.getNetWeight());
        part.setLongDimension(part.getLongDimension());
        part.setWidthDimenion(part.getWidthDimenion());
        part.setTalDimension(part.getTalDimension());
        part.setLastModification(LocalDate.now());// hoy
        PartRecord partRecord = new PartRecord();
        partRecord.setLastModification(LocalDate.now());
        partRecord.setDiscountType(null);
        partRecord.setNormalPrice(newPart.getNormalPrice());
        partRecord.setUrgentPrice(newPart.getUrgentPrice());
        return part;
    }


    public PartDto map(Part part, Boolean isPrice){
        PartDto dto = new PartDto();

        dto.setDescription(part.getDescription());

        PartRecord partRecord = part.getPartRecords().get(part.getPartRecords().size() -1 );
        dto.setDiscountType(partRecord.getDiscountType().getDescription());
        dto.setUrgentPrice(partRecord.getUrgentPrice().toString());

        dto.setNormalPrice(partRecord.getNormalPrice().toString());

        if(isPrice)
            dto.setLastModification(partRecord.getLastModification().toString());
        else
            dto.setLastModification(part.getLastModification().toString());


        dto.setMarker(part.getProvider().getName());
        dto.setPartCode(part.getPartCode());
        dto.setNetWeight(part.getNetWeight().toString());
        dto.setLongDimension(part.getLongDimension().toString());
        dto.setQuantity(part.getStock().getQuantity().toString());
        dto.setTallDimension(part.getTalDimension().toString());
        dto.setWidthDimension(part.getWidthDimenion().toString());

        return dto;
    }
}
