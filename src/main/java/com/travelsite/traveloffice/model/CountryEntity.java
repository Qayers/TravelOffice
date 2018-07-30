package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long continentID;
}
