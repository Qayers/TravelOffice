package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.HotelEntity;

import java.util.List;

public interface HotelService extends CrudService<HotelEntity, Long> {
    List<HotelEntity> findByCityEntity_Id(Long foreignKey);
}
