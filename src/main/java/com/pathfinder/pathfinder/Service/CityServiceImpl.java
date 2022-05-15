package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Repository.CityRepository;
import org.springframework.stereotype.Service;

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
            if (city.getName() != null) {
                foundCity.setName(city.getName());
                foundCity.setLatitude(city.getLatitude());
                foundCity.setLongitude(city.getLongitude());
            }
            cityRepository.save(foundCity);
        return foundCity;
    }

    @Override
    public City getCity(String cityId) {
        return cityRepository.findById(cityId).get();
    }

    @Override
    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
