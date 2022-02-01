package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Place;

import java.util.List;

public interface PlaceService {
    Place addPlace(Place place);
    void deletePlace(Place place);
    Place updatePlace(String placeId, Place place);
    Place getPlace(String placeId);
    List<Place> getAllPlaces();
}
