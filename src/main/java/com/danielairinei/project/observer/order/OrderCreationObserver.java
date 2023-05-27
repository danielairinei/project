package com.danielairinei.project.observer.order;

import com.danielairinei.project.event.EventType;
import com.danielairinei.project.event.OrderEvent;
import com.danielairinei.project.model.Order;
import com.danielairinei.project.model.Product;
import com.danielairinei.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreationObserver implements ApplicationListener<OrderEvent> {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Observer is triggered whenever a new order is created, the eventType attribute is used
     * so that not every observer is triggered whenever an OrderEvent is happening.
     */
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        Order order = orderEvent.getOrder();
        Product product = productRepository.findById(order.getProductId()).orElse(null);

        if (orderEvent.getEventType().equals(EventType.CREATE)) {
            System.out.println("New order for user " + order.getUserEmail() + ". Purchased : " + product.getName());
        }
    }
}
