package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
List<AirportEntity>findByCityEntity_Id(Long ForeignKey);
}
