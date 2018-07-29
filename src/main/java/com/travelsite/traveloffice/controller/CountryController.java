package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CountryController {
    @Qualifier("countryServiceImpl")
    @Autowired
    private CrudService countryService;

    @GetMapping("/country")
    public Iterable getCountryName() {
        return countryService.findAll();
    }

    @PostMapping("/addCountry")
    public ResponseEntity<CountryEntity> addCountry(@RequestBody CountryEntity countryEntity) {
        countryService.add(countryEntity);
        return ResponseEntity.ok(countryEntity);
    }

    @GetMapping("/getCountry/{id}")
    public ResponseEntity<CountryEntity> getCountry(@PathVariable Long id) {
        CountryEntity countryEntity = (CountryEntity) countryService.findOne(id);
        return ResponseEntity.ok(countryEntity);
    }

    @PutMapping(value = "/updateCountry/")
    public ResponseEntity<CountryEntity> update(@RequestBody CountryEntity countryEntity) {
        countryService.modify(countryEntity);
        return ResponseEntity.ok(countryEntity);
    }

    @DeleteMapping(value = "/deleteCountry/{id}")
    public void delete(@PathVariable Long id) {

        countryService.delete(id);
    }

    @GetMapping(value = "/countCountry")
    public ResponseEntity count() {
        return ResponseEntity.ok(countryService.count());
    }
}
