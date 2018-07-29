package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.ContinentEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContinentController {
    @Qualifier("continentServiceImpl")
    @Autowired
    private CrudService continentService;

    @GetMapping("/continent")
    public Iterable getContinentName() {
        return continentService.findAll();
    }

    @PostMapping("/addContinent")
    public ResponseEntity<ContinentEntity> addContinent(@RequestBody ContinentEntity continentEntity){
        continentService.add(continentEntity);
        return ResponseEntity.ok(continentEntity);
    }

    @GetMapping("/getContinent/{id}")
    public ResponseEntity<ContinentEntity> getContinent(@PathVariable int id){
        //TODO
        return null;
    }
    @PutMapping(value = "/updateContinent/{id}")
    public ResponseEntity<ContinentEntity> update(@RequestBody ContinentEntity continentEntity, @PathVariable int id) {
        continentService.modify(continentEntity);
        return ResponseEntity.ok(continentEntity);
    }
    @DeleteMapping(value = "/deleteContinent/{id}")
    public void delete(@PathVariable Long id) {

        continentService.delete(id);
    }

//TODO next metods
}
