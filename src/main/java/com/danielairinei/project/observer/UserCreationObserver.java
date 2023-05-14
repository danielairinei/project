package com.danielairinei.project.observer;

import com.danielairinei.project.event.NewUserEvent;
import com.danielairinei.project.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreationObserver implements ApplicationListener<NewUserEvent> {

    @Override
    public void onApplicationEvent(NewUserEvent userCreatedEvent) {
        User user = userCreatedEvent.getUser();
        System.out.println("New user created: " + user.getUsername() + " " + user.getEmail());
    }
}

