package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_city")
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @JoinColumn(name = "id_country")
    @ManyToOne
    private CountryEntity countryEntity;


}