package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Place;
import com.pathfinder.pathfinder.Repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void deleteCity(City city) {
        cityRepository.delete(city);
    }

    @Override
    public City updateCity(String cityId, City city) {
        var result = cityRepository.findById(cityId);
        var foundCity = result.get();
        if (foundCity != null)
            if (city.getName() != null) foundCity.setName(city.getName());
            if (city.getPlaces() != null) foundCity.setPlaces(city.getPlaces());
            cityRepository.save(foundCity);
        return foundCity;
    }

    @Override
    public City getCity(String cityId) {
        return cityRepository.findById(cityId).get();
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City addPlaceToCity(Place place, City city) {
        if (city.getPlaces() == null)
            city.setPlaces(new ArrayList<>());
        city.getPlaces().add(place);
        cityRepository.save(city);
        return city;
    }

    @Override
    public City removePlaceFromCity(Place place, City city) {
        city.getPlaces().removeIf(i->i.getName().equals(place.getName()));
        return cityRepository.save(city);
    }
}
