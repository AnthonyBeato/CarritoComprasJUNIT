package org.example.models;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest extends TestCase {

    // Test de creación de producto
    public void testCreateProduct(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        assertEquals("1", product.getId());
        assertEquals("Laptop Asus", product.getName());
        assertEquals(1200.0, product.getPrice());
    }

    // Test editar producto
    public void testUpdateProduct(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        product.setId("2");
        product.setName("Laptop Asus Zephyrus G16");
        product.setPrice(1600.0);
        assertEquals("2", product.getId());
        assertEquals("Laptop Asus Zephyrus G16", product.getName());
        assertEquals(1600.0, product.getPrice());
    }

    // Test crear producto con precio negativo
    public void testCreateProductWithNegativePrice(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Product("1","Laptop Asus", -1200.0));
        assertEquals("El precio del producto no puede ser negativo", exception.getMessage());
    }
}
