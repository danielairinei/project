package com.danielairinei.project.service;

import com.danielairinei.project.model.Order;
import com.danielairinei.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public Order getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Order> getOrders() {
        return repository.findAll();
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);

        return "Order was successfully deleted";
    }

    public Order updateOrder(Order order) {
        Order existingOrder = repository.findById(order.getId()).orElse(null);
        existingOrder.setPrice(order.getPrice());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setProductId(order.getProductId());

        return repository.save(existingOrder);
    }
}
