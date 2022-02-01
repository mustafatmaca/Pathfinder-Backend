package com.pathfinder.pathfinder.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("users")
public class User {
    private String id;
    private String mail;
    private String password;
    private String name;
    private String gsm;
    private String role;
    private City city;
    private List<Message> messages;
}