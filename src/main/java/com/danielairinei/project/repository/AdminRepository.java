package com.danielairinei.project.repository;

import com.danielairinei.project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
