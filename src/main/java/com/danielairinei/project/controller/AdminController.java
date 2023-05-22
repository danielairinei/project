package com.danielairinei.project.controller;

import com.danielairinei.project.model.Admin;
import com.danielairinei.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    /**
     * Method used for creating a new admin
     *
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return service.saveAdmin(admin);
    }

    /**
     * Method used for deleting an admin by specifying its id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return service.deleteAdmin(id);
    }

    @GetMapping("/getAdmins")
    public List<Admin> getAdmins() {
        return service.getAdmins();
    }

    @PostMapping("/admin/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        List<Admin> adminList = this.getAdmins();
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username)) {
                if (admin.getPassword().equals(password)) {
                    return "success";
                }
            }
        }
        return "Invalid credentials";
    }

    /**
     * This method is temporary, when an admin will logout, the session key for that admin will be removed, will add spring security logout if in time.
     * @return
     */
    @PostMapping("/admin/logout")
    public String logout(){
        return "success";
    }
}
