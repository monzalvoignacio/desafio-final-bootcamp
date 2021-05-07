package com.mercadolibre.desafio_bootcamp.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String partCode;
    private String description;
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private Stock stock;
    private Integer netWeight;
    private Integer longDimension;
    private Integer widthDimenion;
    private Integer talDimension;
    private LocalDate lastModification;
    @OneToMany(mappedBy = "part",cascade = CascadeType.ALL)
    private List<PartRecord> partRecords;
    @OneToMany(mappedBy = "part")
    private List<OrderDetail> orderDetails;
}