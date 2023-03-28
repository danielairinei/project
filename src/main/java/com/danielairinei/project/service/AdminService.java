package com.danielairinei.project.service;

import com.danielairinei.project.model.Admin;
import com.danielairinei.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }

    public String deleteAdmin(int id) {
        repository.deleteById(id);

        return "Admin deleted successfully!";
    }
}
