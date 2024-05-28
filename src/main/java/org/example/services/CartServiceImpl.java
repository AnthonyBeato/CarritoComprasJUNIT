package org.example.services;

import org.example.models.Cart;
import org.example.models.ItemCart;
import org.example.models.Product;

public class CartServiceImpl implements CartService{
    private final Cart cart = new Cart();

    @Override
    public void addProductToCard(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void eliminateProductFromCart(String productId) {
        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(cart::deleteProduct);
    }

    @Override
    public void modifyQuantity(String productId, int quantity) {
        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(product -> cart.modifyProduct(product, quantity));
    }

    @Override
    public double calculateTotal() {
        return cart.calculateTotal();
    }
}
