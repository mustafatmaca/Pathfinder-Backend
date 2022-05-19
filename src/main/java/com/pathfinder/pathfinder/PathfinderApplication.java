package com.pathfinder.pathfinder;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.User;
import com.pathfinder.pathfinder.Repository.CityRepository;
import com.pathfinder.pathfinder.Service.CityService;
import com.pathfinder.pathfinder.Service.MessageService;
import com.pathfinder.pathfinder.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PathfinderApplication implements CommandLineRunner{
    CityRepository cityRepository;
    CityService cityService;
    UserService userService;
    MessageService messageService;

    public PathfinderApplication(CityRepository cityRepository, CityService cityService ,UserService userService, MessageService messageService) {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
        this.userService = userService;
        this.messageService = messageService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PathfinderApplication.class, args);
    }


    public void run(String... args) throws Exception{
    }
}