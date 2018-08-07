package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.AirportEntity;

import java.util.List;

public interface AirportService extends CrudService<AirportEntity, Long> {
    List<AirportEntity> findByCityEntity_Id(Long foreignKey);
}