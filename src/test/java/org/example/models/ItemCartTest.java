package org.example.models;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemCartTest extends TestCase {

    // Test para Calcular el Total del Carrito de la sesión
    public void testCalculateSubTotal(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        ItemCart item = new ItemCart(product, 2);
        assertEquals(2400.0, item.calculateSubTotal());
    }


    // Test Crear Item en carrito con cantidad negativa
    public void testCreateItemCartWithNegativeQuantity(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ItemCart(product, -2);
        });
        assertEquals("La cantidad debe ser mayor que cero", exception.getMessage());
    }
}
