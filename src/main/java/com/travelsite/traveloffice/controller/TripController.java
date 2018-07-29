package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.PurchasedTripEntity;
import com.travelsite.traveloffice.model.TripEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TripController {
    @Qualifier("tripServiceImpl")
    @Autowired
    private CrudService tripService;

    @GetMapping("/tripFrom")
    public Iterable getAirportFromName() {
        return tripService.findAll();
    }

    @PostMapping("/addTrip")
    public ResponseEntity<TripEntity> addTrip(@RequestBody TripEntity tripEntity) {
        tripService.add(tripEntity);
        return ResponseEntity.ok(tripEntity);
    }

    @GetMapping("/getTrip/{id}")
    public ResponseEntity<TripEntity> getTrip(@PathVariable Long id) {
        TripEntity tripEntity = (TripEntity) tripService.findOne(id);
        return ResponseEntity.ok(tripEntity);
    }

    @PutMapping(value = "/updateTrip/")
    public ResponseEntity<TripEntity> update(@RequestBody TripEntity tripEntity) {
        tripService.modify(tripEntity);
        return ResponseEntity.ok(tripEntity);
    }

    @DeleteMapping(value = "/deleteTrip/{id}")
    public void delete(@PathVariable Long id) {

        tripService.delete(id);
    }

    @GetMapping(value = "/tripCount")
    public ResponseEntity count() {
        return ResponseEntity.ok(tripService.count());
    }
}
