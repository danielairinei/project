package com.danielairinei.project.controller;

import com.danielairinei.project.entity.Admin;
import com.danielairinei.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/addAdmin")
    public Admin addAdmin(Admin admin) {
        return service.saveAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin")
    public String deleteAdmin(int id) {
        return service.deleteAdmin(id);
    }
}
