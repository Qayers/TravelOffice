package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private Long cityID;
}