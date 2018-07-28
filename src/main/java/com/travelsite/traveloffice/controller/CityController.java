package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    @Qualifier("cityServiceImpl")
    @Autowired
    private CrudService cityService;

    @GetMapping("/city")
    public Iterable getCityName() {
        return cityService.findAll();
    }
//TODO next metods
}
