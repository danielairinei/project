package com.danielairinei.project.repository;

import com.danielairinei.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
