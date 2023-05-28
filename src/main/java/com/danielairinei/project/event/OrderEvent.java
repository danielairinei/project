package com.danielairinei.project.event;

import com.danielairinei.project.model.Order;
import org.springframework.context.ApplicationEvent;

public class OrderEvent extends ApplicationEvent {

    private final Order order;
    private final EventType eventType;

    public OrderEvent(EventType eventType, Order order) {
        super(order);
        this.order = order;
        this.eventType = eventType;
    }

    public Order getOrder() {
        return order;
    }

    public EventType getEventType() {
        return eventType;
    }
}
