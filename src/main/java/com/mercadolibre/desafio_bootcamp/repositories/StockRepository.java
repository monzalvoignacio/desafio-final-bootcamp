package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>  {
}
