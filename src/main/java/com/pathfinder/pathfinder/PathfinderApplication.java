package com.pathfinder.pathfinder;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.Place;
import com.pathfinder.pathfinder.Entity.User;
import com.pathfinder.pathfinder.Service.CityService;
import com.pathfinder.pathfinder.Service.MessageService;
import com.pathfinder.pathfinder.Service.PlaceService;
import com.pathfinder.pathfinder.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PathfinderApplication {
    public static void main(String[] args) {
        SpringApplication.run(PathfinderApplication.class, args);
    }
}