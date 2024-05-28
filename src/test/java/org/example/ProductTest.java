package org.example;

import junit.framework.TestCase;
import org.example.models.Product;

public class ProductTest extends TestCase {

    // Test de creación de producto
    public void testCreateProduct(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        assertEquals("1", product.getId());
        assertEquals("Laptop Asus", product.getName());
        assertEquals(1200.0, product.getPrice());
    }
}
