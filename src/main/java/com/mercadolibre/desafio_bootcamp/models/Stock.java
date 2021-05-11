package com.mercadolibre.desafio_bootcamp.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude={"part"})
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne(mappedBy = "stock")
    private Part part;
    private Integer quantity;
}
