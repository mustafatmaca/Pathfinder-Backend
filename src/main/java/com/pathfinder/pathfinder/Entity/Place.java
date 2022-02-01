package com.pathfinder.pathfinder.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("places")
public class Place {
    private String id;
    private String name;
    private String context;
}