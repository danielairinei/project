package com.danielairinei.project.repository;

import com.danielairinei.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
