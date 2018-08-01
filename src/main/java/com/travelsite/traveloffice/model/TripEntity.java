package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "trip")
public class TripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_trip")
    private Long id;
    @JoinColumn(name = "id_airportfrom")
    @ManyToOne
    private AirportEntity airportEntity;

    @JoinColumn(name = "id_airportto")
    @ManyToOne
    private AirportEntity airportEntity1;

    @JoinColumn(name = "id_hotel")
    @ManyToOne
    private HotelEntity hotelEntity;

    private String cityTo;
// Czy podpiąć do City ? Jeśli tak zmaiana wyszukiwania po miastach.

    private Date departureDate;
    private Date returnDate;
    private Integer countOfDays;

    @JoinColumn(name = "type",referencedColumnName = "standard")
    @ManyToOne
    private HotelEntity hotelEntity1;

    private Double priceForAdult;
    private Double priceForChild;
    private Double promotion;
    private Integer countOfPerson;
    private String description;
}
