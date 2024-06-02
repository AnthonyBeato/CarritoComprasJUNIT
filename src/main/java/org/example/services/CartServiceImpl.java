package org.example.services;

import org.example.models.Cart;
import org.example.models.ItemCart;
import org.example.models.Product;
import org.example.validation.Validator;

public class CartServiceImpl implements CartService{
    private final Cart cart;

    public CartServiceImpl() {
        this.cart = new Cart();
    }

    @Override
    public void addProductToCard(Product product, int quantity) {
        Validator.validateProduct(product);
        Validator.validateQuantity(quantity);

        cart.addProduct(product, quantity);
    }

    @Override
    public void eliminateProductFromCart(String productId) {
        Validator.validateProductID(productId);

        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(cart::deleteProduct);
    }

    @Override
    public void eliminateAllProducts() {
        cart.deleteAllProducts();
    }

    @Override
    public void modifyQuantity(String productId, int quantity) {
        Validator.validateProductID(productId);
        Validator.validateQuantity(quantity);

        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(product -> cart.modifyProduct(product, quantity));
    }

    @Override
    public double calculateTotal() {
        return cart.calculateTotal();
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}
