package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.Stock;
import com.mercadolibre.desafio_bootcamp.models.StockCentralHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockCentralHouseRepository extends JpaRepository<StockCentralHouse, Long> {
    StockCentralHouse findByPartIdEqualsAndCentralHouseIdEquals(Long partId, Long centralHouseId);
}
