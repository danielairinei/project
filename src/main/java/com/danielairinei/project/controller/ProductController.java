package com.danielairinei.project.controller;

import com.danielairinei.project.entity.Product;
import com.danielairinei.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
}
