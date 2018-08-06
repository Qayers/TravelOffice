package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface CountryService extends CrudService<CountryEntity, Long> {

    List<CountryEntity> findByContinentEntity_Id(Long foreignKey);
}
