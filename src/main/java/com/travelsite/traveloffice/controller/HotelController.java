package com.travelsite.traveloffice.controller;


import com.sun.xml.internal.bind.api.impl.NameConverter;
import com.travelsite.traveloffice.model.AirportEntity;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.model.HotelEntity;
import com.travelsite.traveloffice.service.CityService;
import com.travelsite.traveloffice.service.HotelService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    @Qualifier("cityServiceImpl")
    private CityService cityService;

    @GetMapping("/hotel")
    public Iterable getHotelName() {
        return hotelService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addHotel")
    public ResponseEntity<HotelEntity> addHotel(@RequestBody HotelRequest hotelRequest) {
        log.info("addHotel: {}", hotelRequest);
        CityEntity cityEntity = cityService.findOne(hotelRequest.getCityEntity());
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName(hotelRequest.getName());
        hotelEntity.setCityEntity(cityEntity);
        hotelEntity.setDescription(hotelRequest.getDescription());
        hotelEntity.setStandard(hotelRequest.getStandard());
        hotelService.add(hotelEntity);
        return ResponseEntity.ok(hotelEntity);
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<HotelEntity> getHotel(@PathVariable Long id) {
        HotelEntity hotelEntity = (HotelEntity) hotelService.findOne(id);
        return ResponseEntity.ok(hotelEntity);
    }

    @PutMapping(value = "/updateHotel/")
    public ResponseEntity<HotelEntity> update(@RequestBody HotelEntity hotelEntity) {
        hotelService.modify(hotelEntity);
        return ResponseEntity.ok(hotelEntity);
    }

    @DeleteMapping(value = "/deleteHotel/{id}")
    public void delete(@PathVariable Long id) {

        hotelService.delete(id);
    }

    @GetMapping(value = "/hotelCount")
    public ResponseEntity count() {
        return ResponseEntity.ok(hotelService.count());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/findByCityEntity_Id/{id}")
    public List<HotelEntity> findByCityEntity_Id(@PathVariable Long id) {
        return hotelService.findByCityEntity_Id(id);
    }

    @Data
    private static class HotelRequest {
        private Long id;
        private String name;
        private Long cityEntity;
        private String description;
        private String standard;

    }
}
