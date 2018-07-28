package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.HotelEntity;
import com.travelsite.traveloffice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HotelServiceImpl extends CrudServiceBaseImpl<HotelEntity> implements HotelService {

    private HotelRepository hotelJpaRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository) {
        super(repository);
        this.hotelJpaRepository = repository;
    }

}
