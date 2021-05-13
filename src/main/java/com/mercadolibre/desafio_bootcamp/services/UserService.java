package com.mercadolibre.desafio_bootcamp.services;

import com.mercadolibre.desafio_bootcamp.dto.responses.BasicResponseDto;

public interface UserService {

    BasicResponseDto createUser(String username, String password) throws Exception;
    BasicResponseDto changeRole(String s, String username) throws Exception;


}
