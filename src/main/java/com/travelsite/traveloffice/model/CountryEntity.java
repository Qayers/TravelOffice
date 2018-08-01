package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name="countryid")

    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name="continentid")
    @OneToMany
   private List<ContinentEntity> continentid;

}
