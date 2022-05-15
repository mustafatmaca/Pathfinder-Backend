package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(User user);
    User updateUser(String userId, User user);
    User getUser(String userId);
    User getUserByMail(String mail);
    User checkLogin(String mail,String password);
    User sendMessageToUser(String userId, Message message);
    List<User> getAllUsers();
    List<User> getGuiders(String role);
    List<User> getGuidersByCity(String role, City city);
}
