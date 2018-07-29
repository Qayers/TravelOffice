package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.HotelEntity;
import com.travelsite.traveloffice.model.PurchasedTripEntity;
import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PurchasedTripController {
    @Qualifier("purchasedTripServiceImpl")
    @Autowired
    private CrudService purchasedTripService;

    @GetMapping("/Trip")
    public Iterable getOwnerName() {
        return purchasedTripService.findAll();
    }

    @PostMapping("/addPurchasedTrip")
    public ResponseEntity<PurchasedTripEntity> addTrip(@RequestBody PurchasedTripEntity purchasedTripEntity) {
        purchasedTripService.add(purchasedTripEntity);
        return ResponseEntity.ok(purchasedTripEntity);
    }

    @GetMapping("/getPurchasedTrip/{id}")
    public ResponseEntity<PurchasedTripEntity> getHotel(@PathVariable Long id) {
        PurchasedTripEntity purchasedTripEntity = (PurchasedTripEntity) purchasedTripService.findOne(id);
        return ResponseEntity.ok(purchasedTripEntity);
    }

    @PutMapping(value = "/updatePurchasedTrip/")
    public ResponseEntity<PurchasedTripEntity> update(@RequestBody PurchasedTripEntity purchasedTripEntity) {
        purchasedTripService.modify(purchasedTripEntity);
        return ResponseEntity.ok(purchasedTripEntity);
    }

    @DeleteMapping(value = "/deletePurchasedTrip/{id}")
    public void delete(@PathVariable Long id) {

        purchasedTripService.delete(id);
    }

    @GetMapping(value = "/purchasedTripCount")
    public ResponseEntity count() {
        return ResponseEntity.ok(purchasedTripService.count());
    }
}
