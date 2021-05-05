package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.AccountType;
import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentralHouseRepository extends JpaRepository<CentralHouse, Long> {
}
