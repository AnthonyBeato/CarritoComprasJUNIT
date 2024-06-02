package org.example.services;

import junit.framework.TestCase;
import org.example.models.Cart;
import org.example.models.Product;
import org.junit.jupiter.api.BeforeEach;

public class CartServiceTest extends TestCase {
    private CartService cartService;
    private ProductService productService;

    //Antes de cada uno, configurar el setup
    public void setUp() {
        cartService = new CartServiceImpl();
        productService = new ProductServiceImpl();
    }
    //TODO: test Add Product To Card
    public void testAddProductToCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 2);
        Cart cart = cartService.getCart();
        assertEquals(1, cart.getItems().size());
    }

    public void testRemoveProductFromCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 2);
        cartService.eliminateProductFromCart("1");
        Cart cart = cartService.getCart();
        assertEquals(0, cart.getItems().size());
    }

    public void testModifyProductFromCart() {
        Product product = new Product("1", "Mouse Logitech", 60);
        productService.addProduct(product);
        cartService.addProductToCard(product, 1);
        cartService.modifyQuantity("1", 3);
        Cart cart = cartService.getCart();
        assertEquals(3, cart.getItems().get(0).getQuantity());
    }


    //TODO: testCalculate Total
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
