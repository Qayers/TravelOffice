package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.ContinentEntity;
import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.ContinentService;
import com.travelsite.traveloffice.service.CountryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
public class CountryController {
    @Qualifier("countryServiceImpl")
    @Autowired
    private CountryService countryService;

    @Autowired
    @Qualifier("continentServiceImpl")
    private ContinentService continentService;

    @GetMapping("/country")
    public Iterable getCountryName() {

        ResponseEntity.ok();
        return countryService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/addCountry")
    public ResponseEntity<CountryEntity> addCountry(@RequestBody CountryRequest countryRequest) {
        log.info("addCountry: {}", countryRequest);
        ContinentEntity continentEntity = continentService.findOne(countryRequest.getContinentEntity());
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setContinentEntity(continentEntity);
        countryEntity.setName(countryRequest.getName());

//        ContinentEntity continentEntity = countryEntity.getContinentEntity();
//        Stream<ContinentEntity> continents = iteratorToStream(continentService.findAll().iterator(),true);
//        List<ContinentEntity> list = continents.collect(Collectors.toList());
//        List<ContinentEntity> checkList = list
//                .stream()
//                .filter(e -> e.getName().equals(continentEntity.getName()))
//                .collect(Collectors.toList());
//
//        if (!checkList.isEmpty()) {
//            countryEntity.setContinentEntity(checkList.get(0));
//        }
        countryService.add(countryEntity);
        return ResponseEntity.ok(countryEntity);
    }

    public static <T> Stream<T> iteratorToStream(final Iterator<T> iterator, final boolean parallell) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallell);
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
        return ResponseEntity.ok(countryService.count());}

    @GetMapping(value = "/findByContinentEntity_Id/{id}")
    public List<CountryEntity> findByContinentEntity_Id(@PathVariable Long id){
        return countryService.findByContinentEntity_Id(id);
    }

    @Data
    private static class CountryRequest {
        private Long id;
        private String name;
        private Long continentEntity;

    }
}
