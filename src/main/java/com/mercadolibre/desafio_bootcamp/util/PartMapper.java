package com.mercadolibre.desafio_bootcamp.util;

import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;

import java.util.Comparator;
import java.util.List;

public class PartMapper {
    public static PartDto map(Part part, Boolean isPrice){
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
