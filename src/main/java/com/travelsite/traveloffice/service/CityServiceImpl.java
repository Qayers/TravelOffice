package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.CityEntity;
import com.travelsite.traveloffice.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl extends CrudServiceBaseImpl<CityEntity> implements CityService {

    private CityRepository cityJpaRepository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        super(repository);
        this.cityJpaRepository = repository;
    }

    @Override
    public List<CityEntity> findByCountryEntity_Id(Long foreignKey){

        return cityJpaRepository.findByCountryEntity_Id(foreignKey);
    }
}
