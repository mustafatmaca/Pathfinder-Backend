package com.pathfinder.pathfinder.Service;

import com.pathfinder.pathfinder.Entity.City;
import com.pathfinder.pathfinder.Entity.Message;
import com.pathfinder.pathfinder.Entity.User;
import com.pathfinder.pathfinder.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(String userId, User user) {
        var result = userRepository.findById(userId);
        var foundUser = result.get();
        if (foundUser != null)
            if (user.getMail() != null) foundUser.setMail(user.getMail());
            if (user.getPassword() != null) foundUser.setPassword(user.getPassword());
            if (user.getName() != null) foundUser.setName(user.getName());
            if (user.getGsm() != null) foundUser.setGsm(user.getGsm());
            if (user.getRole() != null) foundUser.setRole(user.getRole());
            if (user.getCity() != null) foundUser.setCity(user.getCity());
            userRepository.save(foundUser);
        return foundUser;
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User checkLogin(String mail, String password) {
        return userRepository.findByMailAndPassword(mail, password);
    }

    @Override
    public User sendMessageToUser(String userId, Message message) {
        var result = userRepository.findById(userId);
        var foundUser = result.get();
        if (foundUser != null)
            if (foundUser.getMessages() == null)
                foundUser.setMessages(new ArrayList<>());
            foundUser.getMessages().add(message);
        return userRepository.save(foundUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getGuiders(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> getGuidersByCity(String role, City city) {
        return userRepository.findByRoleAndAndCity(role, city);
    }
}
