package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    List<CountryEntity> findByContinentEntity_Id(Long foreignKey);
}
