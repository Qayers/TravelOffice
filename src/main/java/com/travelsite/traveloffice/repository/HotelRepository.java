package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    List<HotelEntity>findByCityEntity_Id(Long foreignKey);
}
