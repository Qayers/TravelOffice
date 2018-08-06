package com.travelsite.traveloffice.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "airport")
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JoinColumn(name = "id_city")
    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private CityEntity cityEntity;

}
