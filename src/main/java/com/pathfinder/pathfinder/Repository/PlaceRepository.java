package com.pathfinder.pathfinder.Repository;

import com.pathfinder.pathfinder.Entity.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<Place, String> {
    Place findByName(String name);
}
