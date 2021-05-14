package com.mercadolibre.desafio_bootcamp.controller;

import com.mercadolibre.desafio_bootcamp.dto.responses.ConcessionarieDto;
import com.mercadolibre.desafio_bootcamp.services.ConcessionariesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/concessionaries")
@Validated
public class ConcessionariesController {

    ConcessionariesService concessionariesService;

    public ConcessionariesController(ConcessionariesService concessionariesService) {
        this.concessionariesService = concessionariesService;
    }

    @GetMapping
    public ResponseEntity getConcessionaries(@RequestParam(name = "centralHouseId", defaultValue = "") String centralHouseId) {
        List<ConcessionarieDto> concessionaries = concessionariesService.getConcessionaries(centralHouseId);
        return ResponseEntity.ok(concessionaries);
    }

    @PostMapping()
    public ResponseEntity<ConcessionarieDto> createConcessionarie(@RequestParam(name = "centralHouseId", defaultValue = "") String centralHouseId, @Valid @RequestBody ConcessionarieDto concessionarieDto) {
        ConcessionarieDto concessionarie = concessionariesService.createConcessionarie(concessionarieDto, centralHouseId);
        return ResponseEntity.ok(concessionarie);
    }

    @PatchMapping()
    public ResponseEntity updateConcessionarie(@Valid @RequestBody ConcessionarieDto concessionarieDto) {
        ConcessionarieDto concessionarie = concessionariesService.updateConcessionarie(concessionarieDto);
        return ResponseEntity.ok(concessionarie);
    }

    @DeleteMapping("/{concessionarieId}")
    public ResponseEntity deleteConcessionarie(@PathVariable String concessionarieId) {
        concessionariesService.deleteConcessionarie(concessionarieId);
        return ResponseEntity.ok().body(null);
    }
}
