package com.mercadolibre.desafio_bootcamp.util;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
