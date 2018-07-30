package com.travelsite.traveloffice.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "airport")
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long cityId;

}
