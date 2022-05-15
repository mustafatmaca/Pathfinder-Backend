package com.pathfinder.pathfinder;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.User;
import com.pathfinder.pathfinder.Repository.CityRepository;
import com.pathfinder.pathfinder.Service.CityService;
import com.pathfinder.pathfinder.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PathfinderApplication implements CommandLineRunner{
    CityRepository cityRepository;
    CityService cityService;
    UserService userService;

    public PathfinderApplication(CityRepository cityRepository, CityService cityService ,UserService userService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PathfinderApplication.class, args);
    }


    public void run(String... args) throws Exception{
    }
}