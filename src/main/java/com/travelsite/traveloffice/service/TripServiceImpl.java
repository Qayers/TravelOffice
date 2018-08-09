package com.travelsite.traveloffice.service;

import com.travelsite.traveloffice.model.TripEntity;
import com.travelsite.traveloffice.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl extends CrudServiceBaseImpl<TripEntity> implements TripService {

    private TripRepository tripJpaRepository;

    @Autowired
    public TripServiceImpl(TripRepository repository) {
        super(repository);
        this.tripJpaRepository = repository;
    }

    @Override
    public List<TripEntity> findByCitiTo_Id(Long CitiId) {
        return tripJpaRepository.findByCityTo_Id(CitiId);

    }

    @Override

    public List<TripEntity> findByCityTo_CountryEntity_Id(Long CountryId) {
        return tripJpaRepository.findByCityTo_CountryEntity_Id(CountryId);
    }

    @Override

    public List<TripEntity> findByCityTo_CountryEntity_ContinentEntity_Id(Long ContinentId) {
        return tripJpaRepository.findByCityTo_CountryEntity_ContinentEntity_Id(ContinentId);
    }

    @Override
    public List<TripEntity> findByHotelEntity_Id(Long HotelId) {
        return tripJpaRepository.findByHotelEntity_Id(HotelId);
    }

    @Override

    public List<TripEntity> findByAirportEntityFrom_Id(Long AirportId) {
        return tripJpaRepository.findByAirportEntityFrom_Id(AirportId);
    }

//    @Override
//    public List<TripEntity> searchByCity(String city) {
//        List<TripEntity> list = tripJpaRepository.findAll()
//                .stream()
//                .filter(trip-> trip.getCityTo().equals(city))
//                .collect(Collectors.toList());
//        return list;
//    }
}
