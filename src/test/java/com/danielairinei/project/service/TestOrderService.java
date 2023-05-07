package com.danielairinei.project.service;

import com.danielairinei.project.model.Order;
import com.danielairinei.project.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestOrderService {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order firstOrder;
    private Order secondOrder;

    private List<Order> orderList;

    /**
     * This method is executed before each test, so I can have orders and a list of orders, necessary for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        firstOrder = new Order(1, 1, "processing", 100, 5);
        secondOrder = new Order(2, 2, "completed", 50, 3);

        orderList = new ArrayList<>();

        orderList.add(firstOrder);
        orderList.add(secondOrder);
    }

    /**
     * JUnit test for addOrder method
     */
    @Test
    public void testAddOrder() {
        Order newOrder = new Order(1, 1, "processing", 100, 5);
        when(orderRepository.save(newOrder)).thenReturn(newOrder);

        Order addedOrder = orderService.createOrder(newOrder);

        assertNotNull(addedOrder);
        Assertions.assertEquals(1, addedOrder.getId());
        Assertions.assertEquals(1, addedOrder.getClientId());
        Assertions.assertEquals("processing", addedOrder.getStatus());
        Assertions.assertEquals(100, addedOrder.getPrice());
        Assertions.assertEquals(5, addedOrder.getProductId());
        verify(orderRepository, times(1)).save(newOrder);
    }

    /**
     * JUnit test for getOrders method
     */
    @Test
    public void testGetOrders() {
        when(orderRepository.findAll()).thenReturn(orderList);

        List<Order> orders = orderService.getOrders();

        Assertions.assertEquals(orderList, orders);
    }

    /**
     * JUnit test for getOrderById method
     */
    @Test
    public void testGetOrderById() {
        when(orderRepository.findById(1)).thenReturn(Optional.of(firstOrder));

        Order order = orderService.getOrderById(1);

        Assertions.assertEquals(firstOrder, order);
    }

    /**
     * JUnit test for deleteOrder method
     */
    @Test
    public void testDeleteOrder() {
        when(orderRepository.existsById(1)).thenReturn(true);

        orderService.deleteOrder(1);

        verify(orderRepository, times(1)).deleteById(1);
    }

    /**
     * JUnit test for updateOrder method
     */
    @Test
    public void testUpdateOrder() {
        when(orderRepository.findById(2)).thenReturn(Optional.of(secondOrder));
        Order updatedOrder = new Order(2, 2, "canceled", 50, 3);
        when(orderRepository.save(any(Order.class))).thenReturn(updatedOrder);

        Order order = orderService.updateOrder(updatedOrder);

        Assertions.assertEquals(updatedOrder, order);
    }
}
