package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.MERGE;


@Data
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_country")
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    @JoinColumn(name = "id_continent")
    @ManyToOne(fetch = FetchType.LAZY,cascade = ALL)
    private ContinentEntity continentEntity;


}
