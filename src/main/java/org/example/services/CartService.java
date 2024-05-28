package org.example.services;

import org.example.models.Cart;
import org.example.models.Product;

public interface CartService {
    void addProductToCard(Product product, int quantity);
    void eliminateProductFromCart(String productId);
    void modifyQuantity(String productId, int quantity);
    double calculateTotal();
}
