package com.danielairinei.project.service;

import com.danielairinei.project.entity.User;
import com.danielairinei.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "Successfully deleted user!";
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        existingUser.setNumberOfOrders(user.getNumberOfOrders());

        return repository.save(existingUser);
    }
}
