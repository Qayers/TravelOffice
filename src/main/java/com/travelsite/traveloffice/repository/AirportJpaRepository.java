package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportJpaRepository extends JpaRepository<AirportEntity, Long> {
}
