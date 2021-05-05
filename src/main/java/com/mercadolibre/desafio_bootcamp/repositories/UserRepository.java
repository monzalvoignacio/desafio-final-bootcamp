package com.mercadolibre.desafio_bootcamp.repositories;

import com.mercadolibre.desafio_bootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
