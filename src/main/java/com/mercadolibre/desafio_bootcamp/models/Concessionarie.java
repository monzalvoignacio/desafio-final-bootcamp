package com.mercadolibre.desafio_bootcamp.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "concessionaries")
public class Concessionarie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;
    @Column(name = "dir")
    private String address;
    private String name;
    @Column(name = "telefono")
    private Integer phone;
    private String country;
    @OneToMany(mappedBy = "concessionarie")
    private List<Order> orders;
    @ManyToOne
    @JoinColumn(name = "central_house_id", nullable = false)
    private CentralHouse centralHouse;
}
