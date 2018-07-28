package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {
}
