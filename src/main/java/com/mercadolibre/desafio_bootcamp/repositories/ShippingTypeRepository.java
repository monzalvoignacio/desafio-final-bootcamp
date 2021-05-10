package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.ShippingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShippingTypeRepository extends JpaRepository<ShippingType, Long> {
    Optional<ShippingType> findByNameEquals(String name);
}
