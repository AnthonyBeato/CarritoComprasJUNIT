package org.example;

import junit.framework.TestCase;
import org.example.services.ProductService;
import org.example.services.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;


public class ProductServiceTest extends TestCase {
    private ProductService productService;

    @BeforeEach
    public void setUp(){
        productService = new ProductServiceImpl();
    }

    //TODO: testAddProduct
    //TODO: testEliminateProduct
}
