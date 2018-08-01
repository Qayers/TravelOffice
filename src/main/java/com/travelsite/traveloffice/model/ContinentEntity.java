package com.travelsite.traveloffice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "continent")
public class ContinentEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @JoinColumn(name = "continentid")
    private Long id;
    private String name;
}
