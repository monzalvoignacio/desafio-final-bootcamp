package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.NewPartDto;
import com.mercadolibre.desafio_bootcamp.dto.PartDto;
import com.mercadolibre.desafio_bootcamp.dto.responses.PartResponseDto;
import com.mercadolibre.desafio_bootcamp.services.PartsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity createPart(@RequestBody NewPartDto newPart){
        return new ResponseEntity(service.createPart(newPart), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity createPart(@RequestParam(name = "partCode") String partCode,
                                     @RequestParam(name = "quantity") Integer quantity){
        return new ResponseEntity(service.updateStock(partCode, quantity), HttpStatus.CREATED);
    }

}
