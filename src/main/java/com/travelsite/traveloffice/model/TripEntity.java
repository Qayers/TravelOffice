package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airportFrom;
    private String airportTo;
    private String hotelTo;
    private String cityTo;
    private String departureDate;
    private String returnDate;
    private Integer countOfDays;
    private String type;
    private Double priceForAdult;
    private Double priceForChild;
    private Double promotion;
    private Integer countOfPerson;
    private String description;
}
