package com.travelsite.traveloffice.controller;

import com.travelsite.traveloffice.model.*;
import com.travelsite.traveloffice.service.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TripController {
    @Qualifier("tripServiceImpl")
    @Autowired
    private TripService tripService;

    @Autowired
    @Qualifier("cityServiceImpl")
    private CityService cityService;

    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Qualifier("airportServiceImpl")
    @Autowired
    private AirportService airportService;


    @GetMapping("/tripFrom")
    public Iterable getAirportFromName() {
        return tripService.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addTrip")
    public ResponseEntity<TripEntity> addTrip(@RequestBody TripRequest tripRequest) {
        log.info("addTrip: {}", tripRequest);
        TripEntity tripEntity = new TripEntity();
        CityEntity cityTo = cityService.findOne(tripRequest.getCityTo());
        tripEntity.setCityTo(cityTo);
        AirportEntity airportEntityFrom = airportService.findOne(tripRequest.getAirportEntityFrom());
        tripEntity.setAirportEntityFrom(airportEntityFrom);
        AirportEntity airportEntityTo = airportService.findOne(tripRequest.getAirportEntityTo());
        tripEntity.setAirportEntityTo(airportEntityTo);
        tripEntity.setCountOfDays(tripRequest.getCountOfDays());
        tripEntity.setCountOfPerson(tripRequest.getCountOfPerson());
        tripEntity.setDepartureDate(tripRequest.getDepartureDate());
        tripEntity.setReturnDate(tripRequest.getReturnDate());
        tripEntity.setDescription(tripRequest.getDescription());
        tripEntity.setPriceForAdult(tripRequest.getPriceForAdult());
        tripEntity.setPriceForChild(tripRequest.priceForChild);
        tripEntity.setPromotion(tripRequest.getPromotion());
        HotelEntity hotelEntity = hotelService.findOne(tripRequest.getHotelEntity());
        tripEntity.setHotelEntity(hotelEntity);
        tripService.add(tripEntity);
        return ResponseEntity.ok(tripEntity);
    }

    @GetMapping("/getTrip/{id}")
    public ResponseEntity<TripEntity> getTrip(@PathVariable Long id) {
        TripEntity tripEntity = tripService.findOne(id);
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

    @GetMapping(value="/tripFindByCitiTo_Id/{id}")
    public List<TripEntity> findByCityEntity_Id(@PathVariable Long id) { return tripService.findByCitiTo_Id(id);
    }

    @GetMapping(value ="/tripFindByCountry_Id/{id}")
    public List<TripEntity> findByCountry_Id(@PathVariable Long id){
        return tripService.findByCityTo_CountryEntity_Id(id);
    }

    @GetMapping(value="/tripFindByContinent_Id/{id}")
    public List<TripEntity> findByContinent_Id(@PathVariable Long id) {
        return tripService.findByCityTo_CountryEntity_ContinentEntity_Id(id);
    }

    @Data
    private static class TripRequest {
        private Long id;
        public Long cityTo;
        public Long airportEntityFrom;
        public Long airportEntityTo;
        public int countOfDays;
        public int countOfPerson;
        public Date departureDate;
        public Date returnDate;
        public String description;
        public double priceForAdult;
        public double priceForChild;
        public double promotion;
        public Long hotelEntity;
    }
}
