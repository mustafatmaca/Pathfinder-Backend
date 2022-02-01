package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Place;

import java.util.List;

public interface CityService {
    City addCity(City city);
    void deleteCity(City city);
    City updateCity(String cityId, City city);
    City getCity(String cityId);
    List<City> getAllCities();
    City addPlaceToCity(Place place, City city);
    City removePlaceFromCity(Place place, City city);
}
