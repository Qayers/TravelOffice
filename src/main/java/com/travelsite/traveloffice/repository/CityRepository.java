package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity>findByCountryEntity_Id(Long foreignKey);

}
