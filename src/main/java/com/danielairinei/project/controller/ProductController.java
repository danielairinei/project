package com.danielairinei.project.controller;

import com.danielairinei.project.entity.Product;
import com.danielairinei.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/getProducts")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @PostMapping("/getProductById/{id}")
    public Product getProductById(int id){
        return service.getProductById(id);
    }

    @PostMapping("/deleteProduct/{id}")
    public String deleteProductById(int id){
        return service.deleteProduct(id);
    }

    @PostMapping("/updateProduct")
    public Product updateProduct(Product product){
        return service.updateProduct(product);
    }
}
