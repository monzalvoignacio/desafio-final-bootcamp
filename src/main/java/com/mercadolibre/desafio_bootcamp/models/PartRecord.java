package com.mercadolibre.desafio_bootcamp.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "part_records")
public class PartRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "discount_type_id")
    private DiscountType discountType;
    private Double normalPrice;
    private Double urgentPrice;
    private LocalDate lastModification;
    @ManyToOne
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;
}
