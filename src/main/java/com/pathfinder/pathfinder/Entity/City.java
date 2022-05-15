package com.pathfinder.pathfinder.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document("cities")
public class City {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
}