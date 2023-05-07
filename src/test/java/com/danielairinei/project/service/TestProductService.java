package com.danielairinei.project.service;

import com.danielairinei.project.model.Product;
import com.danielairinei.project.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestProductService {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product firstProduct;
    private Product secondProduct;

    private List<Product> productList;

    /**
     * This method is executed before each test, so I can have products and a list of products, necessary for testing.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        firstProduct = new Product(1, "First Product", "available", 50, "mockUrl", 1);
        secondProduct = new Product(2, "Second Product", "available", 100, "mockUrl", 1);

        productList = new ArrayList<>();

        productList.add(firstProduct);
        productList.add(secondProduct);
    }

    /**
     * JUnit test for adding a product in the database using the service class
     */
    @Test
    public void testAddProduct() {
        Product newProduct = new Product(1, "Product", "available", 100, "mockUrl", 5);
        when(productRepository.save(newProduct)).thenReturn(newProduct);

        Product addedProduct = productService.saveProduct(newProduct);

        assertNotNull(addedProduct);
        Assertions.assertEquals(1, addedProduct.getId());
        Assertions.assertEquals("Product", addedProduct.getName());
        Assertions.assertEquals("available", addedProduct.getStatus());
        Assertions.assertEquals(100, addedProduct.getPrice());
        Assertions.assertEquals("mockUrl", addedProduct.getPhotoUrl());
        Assertions.assertEquals(5, addedProduct.getIdCategory());
        verify(productRepository, times(1)).save(newProduct);
    }

    /**
     * JUnit test for testing the method getProducts(), method that retrieves all products from the database
     */
    @Test
    public void testGetProducts() {
        when(productRepository.findAll()).thenReturn(productList);

        List<Product> products = productService.getProducts();

        Assertions.assertEquals(productList, products);
    }

    /**
     * JUnit test for the method getProductById, used for retrieving a specific product from the database
     */
    @Test
    public void testGetProductById() {
        when(productRepository.findById(1)).thenReturn(Optional.of(firstProduct));

        Product product = productService.getProductById(1);

        Assertions.assertEquals(firstProduct, product);
    }

    /**
     * JUnit test for the method deleteOrder
     */
    @Test
    public void testDeleteOrder() {
        when(productRepository.existsById(1)).thenReturn(true);

        productService.deleteProduct(1);

        verify(productRepository, times(1)).deleteById(1);
    }

    /**
     * JUnit test for updateProduct method
     */
    @Test
    public void testUpdateProduct() {
        when(productRepository.findById(2)).thenReturn(Optional.of(secondProduct));
        Product updatedProduct = new Product(2, "Second Product", "notAvailable", 100, "mockUrl", 1);
        when(productRepository.save(any(Product.class))).thenReturn(updatedProduct);

        Product order = productService.updateProduct(updatedProduct);

        Assertions.assertEquals(updatedProduct, order);
    }
}
