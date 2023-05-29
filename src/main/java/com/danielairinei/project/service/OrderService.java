package com.danielairinei.project.service;

import com.danielairinei.project.event.EventType;
import com.danielairinei.project.event.OrderEvent;
import com.danielairinei.project.model.Order;
import com.danielairinei.project.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public Order createOrder(Order order) {
        applicationEventPublisher.publishEvent(new OrderEvent(EventType.CREATE, order));

        return orderRepository.save(order);
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public String deleteOrder(int id) {
        orderRepository.deleteById(id);

        return "Order was successfully deleted";
    }

    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
        existingOrder.setPrice(order.getPrice());
        existingOrder.setStatus(order.getStatus());

        return orderRepository.save(existingOrder);
    }
}
