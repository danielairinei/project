package com.danielairinei.project.controller;

import com.danielairinei.project.model.Admin;
import com.danielairinei.project.model.Order;
import com.danielairinei.project.model.User;
import com.danielairinei.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    /**
     * Adds a user to the database
     *
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    /**
     * Retrieves all the users from the users database
     *
     * @return
     */
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return service.getUsers();
    }

    /**
     * Retrieves a user from the users database by its id
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    /**
     * Deletes a user from the database using the id attribute
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable int id) {
        return service.deleteUser(id);
    }

    /**
     * Updates a user from the database
     *
     * @param user
     * @return
     */
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    /**
     * Endpoint for retrieving the list of orders for a specific user
     *
     * @param id
     * @return
     */
    @GetMapping("/getOrderByUserId/{id}")
    public List<Order> getOrdersByUserId(@PathVariable int id) {
        return service.getOrdersByUserId(id);
    }


    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password){
        List<User> userList = this.getUsers();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    return "success";
                }
            }
        }
        return "Invalid credentials";
    }
}
