package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessioanrieRepository extends JpaRepository<Concessionarie, Long> {
}
