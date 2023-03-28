package com.danielairinei.project.controller;

import com.danielairinei.project.model.Order;
import com.danielairinei.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return service.getOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order) {
        return service.updateOrder(order);
    }
}
