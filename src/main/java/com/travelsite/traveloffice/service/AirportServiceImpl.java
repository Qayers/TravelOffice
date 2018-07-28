package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.AirportEntity;
import com.travelsite.traveloffice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AirportServiceImpl extends CrudServiceBaseImpl<AirportEntity> implements AirportService{

    private AirportRepository airportJpaRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository repository) {
        super(repository);
        this.airportJpaRepository = repository;
    }
}