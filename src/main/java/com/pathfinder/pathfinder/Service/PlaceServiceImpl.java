package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.Place;
import com.pathfinder.pathfinder.Repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public void deletePlace(Place place) {
        placeRepository.delete(place);
    }

    @Override
    public Place updatePlace(String placeId, Place place) {
        var result = placeRepository.findById(placeId);
        var foundPlace = result.get();
        if (foundPlace != null)
            if (place.getName() != null) foundPlace.setName(place.getName());
            if (place.getContext() != null) foundPlace.setContext(place.getContext());
            placeRepository.save(foundPlace);
        return foundPlace;
    }

    @Override
    public Place getPlace(String placeId) {
        return placeRepository.findById(placeId).get();
    }

    @Override
    public Place getPlaceByName(String name) {
        return placeRepository.findByName(name);
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }
}
