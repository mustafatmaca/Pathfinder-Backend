package com.pathfinder.pathfinder.Repository;

import com.pathfinder.pathfinder.Entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
