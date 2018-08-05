package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.AirportEntity;
import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.CityService;
import com.travelsite.traveloffice.service.CrudService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j

public class AirportController {
    @Qualifier("airportServiceImpl")
    @Autowired
    private CrudService airportService;

    @Autowired
    @Qualifier("cityServiceImpl")
    private CityService cityService;

    @GetMapping("/airport")
    public Iterable getAirportName() {
        return airportService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addAirport")
    public ResponseEntity<AirportEntity> addAirport(@RequestBody AirportRequest airportRequest) {
        log.info("addAirport: {}", airportRequest);
        CityEntity cityEntity = cityService.findOne(airportRequest.getCityEntity());
        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setName(airportRequest.getName());
        airportEntity.setCityEntity(cityEntity);
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

    @GetMapping(value = "/airportCount")
    public ResponseEntity count() {
        return ResponseEntity.ok(airportService.count());
    }

    @Data
    private static class AirportRequest {
        private Long id;
        private String name;
        private Long cityEntity;

    }
}
