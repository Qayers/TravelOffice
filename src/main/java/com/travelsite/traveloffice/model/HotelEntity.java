package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer standard;
    private String description;
    private Long cityID;
}

