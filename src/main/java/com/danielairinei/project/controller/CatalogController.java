package com.danielairinei.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @GetMapping("/products")
    public String getProducts() {
        return "course";
    }
}
