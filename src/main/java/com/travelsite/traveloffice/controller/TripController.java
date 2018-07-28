package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {
    @Qualifier("tripServiceImpl")
    @Autowired
    private CrudService tripService;

    @GetMapping("/tripFrom")
    public Iterable getAirportFromName() {
        return tripService.findAll();
    }
//TODO next metods
}