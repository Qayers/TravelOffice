package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Qualifier("countryServiceImpl")
    @Autowired
    private CrudService countryService;

    @GetMapping("/country")
    public Iterable getCountryName() {
        return countryService.findAll();
    }
//TODO next metods
}
