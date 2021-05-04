package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.services.PartsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parts")
public class PartsController {
    private PartsService service;

    public PartsController(PartsService pservice){
        service = pservice;
    }

    @GetMapping("/list")
    public ResponseEntity<PartResponseDto> getParts(@RequestParam(name = "queryType", defaultValue = "C",required = false) String queryType,
                                                    @RequestParam(name = "date", defaultValue = "",required = false) String date,
                                                    @RequestParam(name = "order", defaultValue = "" ,required = false) String order) throws Exception {
        return new ResponseEntity<>(service.getParts(queryType,date,order), HttpStatus.OK);
    }
}
