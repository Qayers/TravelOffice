package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.TripEntity;

import java.util.List;

public interface TripService extends CrudService<TripEntity, Long> {

    List<TripEntity> findByCitiTo_Id(Long CitiId);
    List<TripEntity>findByCityTo_CountryEntity_Id(Long CountryId);
    List<TripEntity> findByCityTo_CountryEntity_ContinentEntity_Id(Long ContinentId);



//    List<TripEntity> searchByCity(String city);
}
