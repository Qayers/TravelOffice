package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContinentController {
    @Qualifier("continentServiceImpl")
    @Autowired
    private CrudService continentService;

    @GetMapping("/continent")
    public Iterable getContinentName() {
        return continentService.findAll();
    }
//TODO next metods
}
