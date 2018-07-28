package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.CountryEntity;
import com.travelsite.traveloffice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends CrudServiceBaseImpl<CountryEntity> implements CountryService {

    private CountryRepository countryJpaRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {
        super(repository);
        this.countryJpaRepository = repository;
    }
}