package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Qualifier("cityServiceImpl")
    @Autowired
    private CrudService cityService;

    @GetMapping("/city")
    public Iterable getCityName() {
        return cityService.findAll();
    }

    @PostMapping("/addCity")
    public ResponseEntity<CityEntity> addCity(@RequestBody CityEntity cityEntity) {
        cityService.add(cityEntity);
        return ResponseEntity.ok(cityEntity);
    }

    @GetMapping("/getCity/{id}")
    public ResponseEntity<CityEntity> getCity(@PathVariable Long id) {
        CityEntity cityEntity = (CityEntity) cityService.findOne(id);
        return ResponseEntity.ok(cityEntity);
    }

    @PutMapping(value = "/updateCity/")
    public ResponseEntity<CityEntity> update(@RequestBody CityEntity cityEntity) {
        cityService.modify(cityEntity);
        return ResponseEntity.ok(cityEntity);
    }

    @DeleteMapping(value = "/deleteCity/{id}")
    public void delete(@PathVariable Long id) {

        cityService.delete(id);
    }

    @GetMapping(value = "/countCity")
    public ResponseEntity count() {
        return ResponseEntity.ok(cityService.count());
    }
}
