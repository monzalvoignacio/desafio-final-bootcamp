package com.mercadolibre.desafio_bootcamp.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartDto {
    private String partCode;
    private String description;
    private String marker;
    private String quantity;
    private String discountType;
    private String normalPrice;
    private String urgentPrice;
    private String netWeight;
    private String longDimension;
    private String widthDimension;
    private String tallDimension;
    private String lastModification;
}
