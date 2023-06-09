package com.danielairinei.project.controller;

import com.danielairinei.project.model.Product;
import com.danielairinei.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Add a product to DB.
     *
     * @param product
     * @return
     */
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    /**
     * Gets products from DB.
     *
     * @return
     */
    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    /**
     * Gets a product from DB specified by its ID.
     *
     * @param id
     * @return
     */
    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    /**
     * Delete a product from DB specified by its ID.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    /**
     * Updates a product from the DB.
     *
     * @param product
     * @return
     */
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }
}
