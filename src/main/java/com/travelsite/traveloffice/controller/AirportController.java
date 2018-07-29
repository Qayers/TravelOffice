package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.AirportEntity;
import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirportController {
    @Qualifier("airportServiceImpl")
    @Autowired
    private CrudService airportService;

    @GetMapping("/airport")
    public Iterable getAirportName() {
        return airportService.findAll();
    }

    @PostMapping("/addAirport")
    public ResponseEntity<AirportEntity> addAirport(@RequestBody AirportEntity airportEntity) {
        airportService.add(airportEntity);
        return ResponseEntity.ok(airportEntity);
    }

    @GetMapping("/getAirport/{id}")
    public ResponseEntity<AirportEntity> getAirport(@PathVariable Long id) {
        AirportEntity airportEntity = (AirportEntity) airportService.findOne(id);
        return ResponseEntity.ok(airportEntity);
    }

    @PutMapping(value = "/updateAirport/")
    public ResponseEntity<AirportEntity> update(@RequestBody AirportEntity airportEntity) {
        airportService.modify(airportEntity);
        return ResponseEntity.ok(airportEntity);
    }

    @DeleteMapping(value = "/deleteAirport/{id}")
    public void delete(@PathVariable Long id) {

        airportService.delete(id);
    }

    @GetMapping(value = "/airportCountry")
    public ResponseEntity count() {
        return ResponseEntity.ok(airportService.count());
    }
}
