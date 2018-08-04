package com.travelsite.traveloffice.model;

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
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private AirportEntity airportEntityFrom;

    @JoinColumn(name = "id_airportto")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private AirportEntity airportEntityTo;

    @JoinColumn(name = "id_hotel")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private HotelEntity hotelEntity;

    @JoinColumn(name="id_city")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
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
