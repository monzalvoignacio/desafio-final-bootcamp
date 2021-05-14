package com.mercadolibre.desafio_bootcamp.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "central_houses")
public class CentralHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;
    private String country;
    @Column(name = "telefono")
    private Integer phone;
    private String name;
    @Column(name = "dir")
    private String address;
    @OneToMany(mappedBy = "centralHouse")
    private List<Order> orders;
    @OneToMany(mappedBy = "centralHouse")
    private List<StockCentralHouse> centralHouseStocks;
    @OneToMany(mappedBy = "centralHouse")
    private List<Concessionarie> concessionaries;
}
