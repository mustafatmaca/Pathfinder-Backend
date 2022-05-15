package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;

import java.util.List;

public interface CityService {
    City addCity(City city);
    void deleteCity(City city);
    City updateCity(String cityId, City city);
    City getCity(String cityId);
    City getCityByName(String name);
    List<City> getAllCities();
}
