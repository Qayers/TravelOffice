package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.HotelEntity;
import com.travelsite.traveloffice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl extends CrudServiceBaseImpl<HotelEntity> implements HotelService {

    private HotelRepository hotelJpaRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository repository) {
        super(repository);
        this.hotelJpaRepository = repository;
    }

    @Override
    public List<HotelEntity>findByCityEntity_Id(Long foreignKey){

        return hotelJpaRepository.findByCityEntity_Id(foreignKey);
    }

}
