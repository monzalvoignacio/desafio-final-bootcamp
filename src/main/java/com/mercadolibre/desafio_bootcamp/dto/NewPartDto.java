package com.mercadolibre.desafio_bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.desafio_bootcamp.models.OrderDetail;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;
import com.mercadolibre.desafio_bootcamp.models.Provider;
import com.mercadolibre.desafio_bootcamp.models.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPartDto{
    private Long id;
    @JsonProperty("orderNumber")
    private String partCode;
    private String description;
    @JsonProperty("orderNumber")
    private Long providerId;
    private Integer stock;
    @JsonProperty("orderNumber")
    private Integer netWeight;
    @JsonProperty("orderNumber")
    private Integer longDimension;
    @JsonProperty("orderNumber")
    private Integer widthDimension;
    @JsonProperty("orderNumber")
    private Integer talDimension;
    @JsonProperty("orderNumber")
    private LocalDate lastModification;
    @JsonProperty("orderNumber")
    private Long discountTypeId;
    @JsonProperty("orderNumber")
    private Double normalPrice;
    @JsonProperty("orderNumber")
    private Double urgentPrice;
}
