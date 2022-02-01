package com.pathfinder.pathfinder.Repository;

import com.pathfinder.pathfinder.Entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
