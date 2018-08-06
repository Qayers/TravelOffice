package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.CityEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityService extends CrudService<CityEntity, Long> {

    List<CityEntity> findByCountryEntity_Id(Long foreignKey);

}
