package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.model.ContinentEntity;
import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.CityService;
import com.travelsite.traveloffice.service.ContinentService;
import com.travelsite.traveloffice.service.CountryService;
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
public class CityController {
    @Qualifier("cityServiceImpl")
    @Autowired
    private CityService cityService;

    @Autowired
    @Qualifier("countryServiceImpl")
    private CountryService countryService;

    @GetMapping("/city")
    public Iterable getCityName() {

        return cityService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCity")
    public ResponseEntity<CityEntity> addCity(@RequestBody CityRequest cityRequest) {
        log.info("addCity: {}", cityRequest);
        CountryEntity countryEntity = countryService.findOne(cityRequest.getCountryEntity());
        CityEntity cityEntity = new CityEntity();
        cityEntity.setCountryEntity(countryEntity);
        cityEntity.setName(cityRequest.getName());
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

    @GetMapping(value = "/findByCountryEntity_Id/{id}")
    public List<CityEntity> findByCountryEntity_Id(@PathVariable Long id){

        return cityService.findByCountryEntity_Id(id);
    }

    @Data
    private static class CityRequest {
        private Long id;
        private String name;
        private Long countryEntity;

    }
}
