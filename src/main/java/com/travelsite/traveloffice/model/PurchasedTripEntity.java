package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "purchasedtrip")
public class PurchasedTripEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_trip")
    private TripEntity tripEntity;
    private Double amount;
    private String owner;
}
