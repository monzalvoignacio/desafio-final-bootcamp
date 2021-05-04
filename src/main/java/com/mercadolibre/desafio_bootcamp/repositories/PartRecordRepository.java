package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.Part;
import com.mercadolibre.desafio_bootcamp.models.PartRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartRecordRepository extends JpaRepository<PartRecord, Long> {
    public List<PartRecord> findByLastModificationAfter(LocalDate date);
}
