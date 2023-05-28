package com.danielairinei.project.observer.user;

import com.danielairinei.project.event.EventType;
import com.danielairinei.project.event.UserEvent;
import com.danielairinei.project.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreationObserver implements ApplicationListener<UserEvent> {

    /**
     * Observer is triggered whenever a new user is created, the eventType attribute is used
     * so that not every observer is triggered whenever an UserEvent is happening.
     *
     * @param userEvent
     */
    @Override
    public void onApplicationEvent(UserEvent userEvent) {
        User user = userEvent.getUser();
        if (userEvent.getEventType().equals(EventType.CREATE)) {
            System.out.println("New user created: " + user.getUsername() + " " + user.getEmail());
        }
    }
}
