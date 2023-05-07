package com.danielairinei.project.controller;

import com.danielairinei.project.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Not a complete class, don't know if it's gonna be in the final version of the backend
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        // validate
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "welcome";
    }
}
