package com.danielairinei.project.controller;

import com.danielairinei.project.model.Admin;
import com.danielairinei.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    /**
     * Method used for creating a new admin
     * @param admin
     * @return
     */
    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return service.saveAdmin(admin);
    }

    /**
     * Method used for deleting an admin by specifying its id
     * @param id
     * @return
     */
    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable int id) {
        return service.deleteAdmin(id);
    }
}
