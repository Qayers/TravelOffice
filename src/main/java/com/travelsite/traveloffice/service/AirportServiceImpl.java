package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.AirportEntity;
import com.travelsite.traveloffice.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl extends CrudServiceBaseImpl<AirportEntity> implements AirportService{

    private AirportRepository airportJpaRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository repository) {
        super(repository);
        this.airportJpaRepository = repository;
    }
    @Override
    public List<AirportEntity> findByCityEntity_Id(Long foreignKey){

        return airportJpaRepository.findByCityEntity_Id(foreignKey);
    }
}