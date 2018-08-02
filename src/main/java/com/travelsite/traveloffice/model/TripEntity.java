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
    private AirportEntity airportEntity;

    @JoinColumn(name = "id_airportto")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private AirportEntity airportEntity1;

    @JoinColumn(name = "id_hotel")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private HotelEntity hotelEntity;

    private String cityTo;
// Czy podpiąć do City ? Jeśli tak zmaiana wyszukiwania po miastach.

    private Date departureDate;
    private Date returnDate;
    private Integer countOfDays;

    @JoinColumn(name = "type",referencedColumnName = "standard")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private HotelEntity hotelEntity1;

    private Double priceForAdult;
    private Double priceForChild;
    private Double promotion;
    private Integer countOfPerson;
    private String description;
}
