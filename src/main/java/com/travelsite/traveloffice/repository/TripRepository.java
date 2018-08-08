package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, Long> {

    List<TripEntity>findByCityTo_Id(Long CitiId);


    List<TripEntity>findByCityTo_CountryEntity_Id(Long CountryId);


    List<TripEntity>findByCityTo_CountryEntity_ContinentEntity_Id(Long ContinentId);

}
