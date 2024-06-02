package org.example.services;

import junit.framework.TestCase;
import org.example.models.Product;


public class ProductServiceTest extends TestCase {
    private ProductService productService;


    public void setUp(){
        productService = new ProductServiceImpl();
    }

    //TODO: testAddProduct
    public void testAddProduct(){
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        assertNotNull(productService.getProductById("1"));
    }
    

    //TODO: testEliminateProduct
    public void testRemoveProduct(){
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        productService.deleteProduct("1");
        assertNull(productService.getProductById("1"));
    }
}
