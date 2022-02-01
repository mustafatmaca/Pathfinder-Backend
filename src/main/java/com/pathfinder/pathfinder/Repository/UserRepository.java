package com.pathfinder.pathfinder.Repository;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByMail(String mail);
    List<User> findByRole(String role);
    List<User> findByRoleAndAndCity(String role, City city);
}
