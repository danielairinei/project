package com.danielairinei.project.controller;

import com.danielairinei.project.entity.User;
import com.danielairinei.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable int id){
        return service.deleteUser(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
}
