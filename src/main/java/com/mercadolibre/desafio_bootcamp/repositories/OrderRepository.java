package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.DeliveryStatus;
import com.mercadolibre.desafio_bootcamp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByConcessionarieIdEqualsAndDeliveryStatusIdEquals(Long concessionary_id, Long delivery_id);
    List<Order> findOrderByConcessionarieIdEquals(Long concessionarie_id);
    List<Order> findOrderByConcessionarieIdEqualsAndCentralHouseIdEqualsAndOrderNumberCMEquals(Long concessionaryId, Long centralHouseId, Integer orderNumberCM);
}
