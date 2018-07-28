package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.PurchasedTripEntity;
import com.travelsite.traveloffice.repository.PurchasedTripRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchasedTripServiceImpl extends CrudServiceBaseImpl<PurchasedTripEntity> implements PurchasedTripService {

    private PurchasedTripRepository purchasedTripJpaRepository;

    @Autowired
    public PurchasedTripServiceImpl(PurchasedTripRepository repository) {
        super(repository);
        this.purchasedTripJpaRepository = repository;
    }
}
