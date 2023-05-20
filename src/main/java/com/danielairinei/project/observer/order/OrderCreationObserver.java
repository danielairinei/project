package com.danielairinei.project.observer.order;

import com.danielairinei.project.event.EventType;
import com.danielairinei.project.event.OrderEvent;
import com.danielairinei.project.model.Order;
import com.danielairinei.project.model.Product;
import com.danielairinei.project.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreationObserver implements ApplicationListener<OrderEvent> {

    /**
     * Observer is triggered whenever a new order is created, the eventType attribute is used
     * so that not every observer is triggered whenever an OrderEvent is happening.
     */
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        Order order = orderEvent.getOrder();
        User user = order.getUser();
        Product product = order.getProduct();

        if (orderEvent.getEventType().equals(EventType.CREATE)) {
            System.out.println("New order for user " + user.getUsername() + ". Purchased : " + product.getName());
        }
    }
}
