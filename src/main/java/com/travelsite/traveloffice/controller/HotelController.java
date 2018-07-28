package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private CrudService hotelService;

    @GetMapping("/holel")
    public Iterable getHolelName() {
        return hotelService.findAll();
    }
//TODO next metods
}
