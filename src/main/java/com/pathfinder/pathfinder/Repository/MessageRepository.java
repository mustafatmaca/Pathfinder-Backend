package com.pathfinder.pathfinder.Repository;

import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findBySender(User user);
    List<Message> findByToUser(User user);
}
