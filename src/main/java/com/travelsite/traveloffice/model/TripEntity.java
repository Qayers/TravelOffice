package com.travelsite.traveloffice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_trip")
    private Long id;

    @JoinColumn(name = "id_airportfrom")
    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private AirportEntity airportEntityFrom;

    @JoinColumn(name = "id_airportto")
    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private AirportEntity airportEntityTo;

    @JoinColumn(name = "id_hotel")
    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private HotelEntity hotelEntity;

    @JoinColumn(name="id_city")
    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private CityEntity cityTo;

    private Date departureDate;
    private Date returnDate;
    private Integer countOfDays;


    private Double priceForAdult;
    private Double priceForChild;
    private Double promotion;
    private Integer countOfPerson;
    private String description;
}
