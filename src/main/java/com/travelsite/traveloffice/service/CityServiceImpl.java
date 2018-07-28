package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceImpl extends CrudServiceBaseImpl<CityEntity> implements CityService {

    private CityRepository cityJpaRepository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        super(repository);
        this.cityJpaRepository = repository;
    }





}
