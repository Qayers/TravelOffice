package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.model.ContinentEntity;
import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.service.ContinentService;
import com.travelsite.traveloffice.service.CountryService;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CityController {
    @Qualifier("cityServiceImpl")
    @Autowired
    private CrudService cityService;

    @Autowired
    @Qualifier("continentServiceImpl")
    private ContinentService continentService;

    @Autowired
    @Qualifier("countryServiceImpl")
    private CountryService countryService;

    @GetMapping("/city")
    public Iterable getCityName() {

        return cityService.findAll();
    }

    @PostMapping("/addCity")
    public ResponseEntity<CityEntity> addCity(@RequestBody CityEntity cityEntity) {

        CountryEntity countryEntity = cityEntity.getCountryEntity();
        Stream<CountryEntity> countries = iteratorToStream(countryService.findAll().iterator(),true);
        List<CountryEntity> list = countries.collect(Collectors.toList());
        List<CountryEntity> checkList = list
                .stream()
                .filter(e -> e.getName().equals(countryEntity.getName()))
                .collect(Collectors.toList());

        if (!checkList.isEmpty()) {
            cityEntity.setCountryEntity(checkList.get(0));
        }else{
            ContinentEntity continentEntity = countryEntity.getContinentEntity();
            Stream<ContinentEntity> continents = iteratorToStream(continentService.findAll().iterator(),true);
            List<ContinentEntity> list2 = continents.collect(Collectors.toList());
            List<ContinentEntity> checkList2 = list2
                    .stream()
                    .filter(e -> e.getName().equals(continentEntity.getName()))
                    .collect(Collectors.toList());

            if (!checkList2.isEmpty()) {
                countryEntity.setContinentEntity(checkList2.get(0));
                cityEntity.setCountryEntity(countryEntity);
            }
        }
        
        cityService.add(cityEntity);
        return ResponseEntity.ok(cityEntity);
    }


    public static <T> Stream<T> iteratorToStream(final Iterator<T> iterator, final boolean parallell) {
        Iterable<T> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), parallell);
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
