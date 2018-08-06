package com.travelsite.traveloffice.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;


@Data
@Entity
@Table(name = "hotel")
public class HotelEntity {


//    public enum  Standard {
//        BB("BB (bed & breakfast) – samo śniadanie"),
//        HB("HB (half board) – śniadanie i obiadokolacja"),
//        FB("FB (full board) – pełne wyżywienie, które obejmuje śniadanie, obiad, kolację"),
//        AI("AI (all inclusive) – pełne wyżywienie, które obejmuje śniadanie, obiad, kolację, a ponadto napoje bezalkoholowe i alkohole, najczęściej regionalne, przekąski między posiłkami"),
//        OV("OV (overnight) – sam nocleg, bez wyżywienia"),
//        SC("SC (self catering) – oznacza wyżywienie gościa we własnym zakresie"),
//        PP("PP (program package) – posiłki wydawane zgodnie z programem"),
//        ZPR("ZPR – posiłki wydawane zgodnie z programem hotelu lub opisem imprezy");
//
//        Standard(String s) {
//        }
//
//        ;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hotel")
    private Long id;


    @Column(nullable = false,unique = true)

    private String name;

    @Column(nullable = false)

    private String standard;

    private String description;

    @JoinColumn(name = "id_city")
    @ManyToOne(fetch = FetchType.LAZY, cascade = ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private CityEntity cityEntity;

}

