package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.CentralHouse;
import com.mercadolibre.desafio_bootcamp.models.Concessionarie;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcessioanrieRepository extends JpaRepository<Concessionarie, Long> {
    List<Concessionarie> findByCentralHouseIdEquals(Long centralHouseId);
    List<Concessionarie> findByNameEquals(String name);
    List<Concessionarie> findByPhoneEquals(Integer phone);
}
