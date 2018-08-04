package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "purchasedtrip")
public class PurchasedTripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne (fetch = FetchType.LAZY,cascade = ALL)
    @JoinColumn(name = "id_trip")
    private TripEntity tripEntity;
    private Double amount;
    private String owner;
}
