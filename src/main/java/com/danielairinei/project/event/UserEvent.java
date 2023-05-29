package com.danielairinei.project.event;

import com.danielairinei.project.model.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent extends ApplicationEvent {

    private final User user;
    private final EventType eventType;

    public UserEvent(EventType eventType, User user) {
        super(user);
        this.user = user;
        this.eventType = eventType;
    }

    public User getUser() {
        return user;
    }

    public EventType getEventType() {
        return eventType;
    }
}
