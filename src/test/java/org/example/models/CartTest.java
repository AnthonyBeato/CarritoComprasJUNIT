package org.example.models;

import junit.framework.TestCase;

public class CartTest extends TestCase {

    // Test Añadir producto al carrito
    public void testAddProduct() {
        Cart cart = new Cart();
        Product product = new Product("1", "Teclado Mecánico", 50);
        cart.addProduct(product, 3);
        assertEquals(1, cart.getItems().size());
    }

    // Test remover producto del carrito
    public void testRemoveProduct() {
        Cart cart = new Cart();
        Product product = new Product("1", "Teclado Mecánico", 50);
        cart.addProduct(product, 3);
        cart.deleteProduct(product);
        assertEquals(0, cart.getItems().size());
    }

    // Test modificar cantidad de un producto
    public void testModifyProduct() {
        Cart cart = new Cart();
        Product product = new Product("1", "Teclado Mecánico", 50);
        cart.addProduct(product, 3);
        cart.modifyProduct(product, 1);
        assertEquals(1, cart.getItems().get(0).getQuantity());
    }

    // Test remover todos los productos del carrito
    public void testRemoveAllProducts() {
        Cart cart = new Cart();
        Product product1 = new Product("1", "Teclado Mecánico", 50);
        Product product2 = new Product("2", "Mouse Logitech", 70);
        Product product3 = new Product("3", "Monitor 4K", 300);
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
        cart.addProduct(product3, 1);
        cart.deleteAllProducts();
    }

    // Test calcular total del carrito
    public void testCalculateTotal() {
        Cart cart = new Cart();
        Product product1 = new Product("1", "Teclado Mecánico", 50);
        Product product2 = new Product("2", "Mouse Logitech", 70);
        Product product3 = new Product("3", "Monitor 4K", 300);
        cart.addProduct(product1, 1);
        cart.addProduct(product2, 2);
        cart.addProduct(product3, 1);
        assertEquals(490.0, cart.calculateTotal(), 0.001);
    }
}
