package com.danielairinei.project.controller;

import com.danielairinei.project.model.Order;
import com.danielairinei.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    /**
     * Method used for creating an order in the Order database.
     *
     * @param order
     * @return
     */
    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    /**
     * Method used for getting the list of orders.
     *
     * @return
     */
    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return service.getOrders();
    }

    /**
     * Method used for getting a specific order by the id attribute
     *
     * @param id
     * @return
     */
    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    /**
     * Method used for deleting a specific order using the order id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }

    /**
     * Method used for updating an order
     *
     * @param order
     * @return
     */
    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order) {
        return service.updateOrder(order);
    }
}
