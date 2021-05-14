package com.mercadolibre.desafio_bootcamp.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "dir")
    private String address;
    @Column(name = "telefono")
    private String phone;
    private String country;
    @OneToMany(mappedBy = "provider")
    private List<Part> parts;
}
