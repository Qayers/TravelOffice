package com.travelsite.traveloffice.model;


import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "airport")
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_airport")
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    @JoinColumn(name = "id_city")
    @ManyToOne(fetch = FetchType.EAGER,cascade = ALL)
    private CityEntity cityEntity;

}
