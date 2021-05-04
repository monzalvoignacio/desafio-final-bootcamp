package com.mercadolibre.desafio_bootcamp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartsController {
    @GetMapping("/api/v1/parts")
    public ResponseEntity getParts(@RequestParam(name = "queryType", defaultValue = "C") char queryType, @RequestParam(name = "date", defaultValue = "") String date, @RequestParam(name = "order") String order) {
        return null;
    }
}
