package com.pathfinder.pathfinder.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("messages")
public class Message {
    private String id;
    private User sender;
    private User toUser;
    private String context;
}