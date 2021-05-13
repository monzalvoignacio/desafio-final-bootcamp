package com.mercadolibre.desafio_bootcamp.models;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "central_house")
public class CentralHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    private Long id;
    private String country;
    private Integer phone;
    private String name;
    private String address;
    @OneToMany(mappedBy = "centralHouse")
    private List<Order> orders;
    @OneToMany(mappedBy = "centralHouse")
    private List<StockCentralHouse> centralHouseStocks;

}
