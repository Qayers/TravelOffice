package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.TripEntity;
import com.travelsite.traveloffice.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl extends CrudServiceBaseImpl<TripEntity> implements TripService {

    private TripRepository tripJpaRepository;

    @Autowired
    public TripServiceImpl(TripRepository repository) {
        super(repository);
        this.tripJpaRepository = repository;
    }
}
