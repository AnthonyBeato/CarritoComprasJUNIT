package org.example.services;

import junit.framework.TestCase;
import org.example.models.Cart;
import org.example.models.Product;
import org.junit.jupiter.api.BeforeEach;

public class CartServiceTest extends TestCase {
    private CartService cartService;
    private ProductService productService;

    public void setUp() {
        cartService = new CartServiceImpl();
        productService = new ProductServiceImpl();
    }

    // Test para añadir un producto al carrito
    public void testAddProductToCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 2);
        Cart cart = cartService.getCart();
        assertEquals(1, cart.getItems().size());
    }

    // Test para remover un producto del carrito
    public void testRemoveProductFromCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 2);
        cartService.eliminateProductFromCart("1");
        Cart cart = cartService.getCart();
        assertEquals(0, cart.getItems().size());
    }

    // Test para modificar un producto del carrito
    public void testModifyProductFromCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 1);
        cartService.modifyQuantity("1", 3);
        Cart cart = cartService.getCart();
        assertEquals(3, cart.getItems().get(0).getQuantity());
    }


    // Test para calcular el total del carrito
    public void testCalculateTotal() {
        Product product = new Product("1", "Mouse Logitech", 60);
        Product product2 = new Product("2", "Mouse Razer", 60);
        productService.addProduct(product);
        productService.addProduct(product2);
        cartService.addProductToCard(product, 2);
        cartService.addProductToCard(product2, 1);
        assertEquals(180.0, cartService.calculateTotal());
    }
}
