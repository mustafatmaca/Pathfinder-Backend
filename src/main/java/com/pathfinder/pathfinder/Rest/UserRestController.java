package com.pathfinder.pathfinder.Rest;

import com.pathfinder.pathfinder.Entity.Response;
import com.pathfinder.pathfinder.Entity.User;
import com.pathfinder.pathfinder.Service.CityService;
import com.pathfinder.pathfinder.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserRestController {
    UserService userService;
    CityService cityService;

    public UserRestController(UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    @PostMapping("/")
    public Response<User> addUser(@RequestBody User user){
        try {
            var response = userService.addUser(user);
            return new Response<>(true,"User added",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @DeleteMapping("/{mail}")
    public Response<Boolean> deleteUser(@PathVariable String mail){
        try {
            var response = userService.getUserByMail(mail);
            if (response != null)
                userService.deleteUser(response);
                return new Response<>(true,"User deleted",true);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),false);
        }
    }

    @PutMapping("/{mail}")
    public Response<User> updateUser(@PathVariable String mail, @RequestBody User user){
        try {
            var response = userService.getUserByMail(mail);
            if (response != null)
                userService.updateUser(response.getId(), user);
                return new Response<>(true,"Updated Succesfuly",response);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/{mail}")
    public Response<User> getUserByMail(@PathVariable String mail) {
        try {
            var response = userService.getUserByMail(mail);
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"User not found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/")
    public Response<List<User>> getAllUsers(){
        try {
            var response = userService.getAllUsers();
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"No users found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/Guiders/{role}")
    public Response<List<User>> getGuiders(@PathVariable String role){
        try {
            var response = userService.getGuiders(role);
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"No guiders found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @GetMapping("/Guiders/{city}/{role}")
    public Response<List<User>> getGuidersByCity(@PathVariable String role, @PathVariable String city){
        try {
            var foundCity = cityService.getCityByName(city);
            var response = userService.getGuidersByCity(role,foundCity);
            if (response != null)
                return new Response<>(true,null,response);
            else
                return new Response<>(false,"No guiders found",null);
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }
    }

}
