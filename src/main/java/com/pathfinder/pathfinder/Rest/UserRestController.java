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
    public User addUser(@RequestBody User user){
        try {
            var response = userService.addUser(user);
            return response;
        } catch (Exception e) {
            return null;
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
    public User getUserByMail(@PathVariable String mail) {
        try {
            var response = userService.getUserByMail(mail);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/{mail}/{password}")
    public User checkLogin(@PathVariable String mail,@PathVariable String password) {
        try{
            var response = userService.checkLogin(mail,password);
            if(response != null)
                return response;
            else
                return null;
        }
        catch(Exception ex){
            return null;
        }
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        try {
            var response = userService.getAllUsers();
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/Guiders/{role}")
    public List<User> getGuiders(@PathVariable String role){
        try {
            var response = userService.getGuiders(role);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/Guiders/{city}/{role}")
    public List<User> getGuidersByCity(@PathVariable String role, @PathVariable String city){
        try {
            var foundCity = cityService.getCityByName(city);
            var response = userService.getGuidersByCity(role,foundCity);
            if (response != null)
                return response;
            else
                return null;
        } catch (Exception e) {
            return null;
        }
    }

}
