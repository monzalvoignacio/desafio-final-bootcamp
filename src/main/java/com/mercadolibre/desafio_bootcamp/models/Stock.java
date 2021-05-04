package com.mercadolibre.desafio_bootcamp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(mappedBy = "stock")
    private Part part;
    private Integer quantity;
}
