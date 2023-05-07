package com.danielairinei.project.service;

import com.danielairinei.project.model.Admin;
import com.danielairinei.project.repository.AdminRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestAdminService {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    private Admin admin;

    private List<Admin> adminList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        admin = new Admin(1,"test","test");

        adminList = new ArrayList<>();

        adminList.add(admin);
    }

    @Test
    public void testAddAdmin() {
        Admin newAdmin = new Admin(1, "admin1", "password1");
        when(adminRepository.save(newAdmin)).thenReturn(newAdmin);

        Admin addedAdmin = adminService.saveAdmin(newAdmin);

        assertNotNull(addedAdmin);
        Assertions.assertEquals("admin1", addedAdmin.getUsername());
        Assertions.assertEquals("password1", addedAdmin.getPassword());
        verify(adminRepository, times(1)).save(newAdmin);
    }

    @Test
    public void testDeleteAdmin() {
        when(adminRepository.existsById(1)).thenReturn(true);

        adminService.deleteAdmin(1);

        verify(adminRepository, times(1)).deleteById(1);
    }
}
