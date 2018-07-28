package com.travelsite.traveloffice.repository;

import com.travelsite.traveloffice.model.PurchasedTripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedTripRepository extends JpaRepository <PurchasedTripEntity, Long> {
}
