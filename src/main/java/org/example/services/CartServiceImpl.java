package org.example.services;

import org.example.models.Cart;
import org.example.models.ItemCart;
import org.example.models.Product;
import org.example.validation.Validator;

// Implementación de Servicio de Carrito
public class CartServiceImpl implements CartService{
    private final Cart cart;

    public CartServiceImpl() {
        // Inicialización de objeto de carrito para la sesión
        this.cart = new Cart();
    }

    // Método para añadir un producto al carrito
    @Override
    public void addProductToCard(Product product, int quantity) {
        Validator.validateProduct(product);
        Validator.validateQuantity(quantity);

        cart.addProduct(product, quantity);
    }

    // Método para eliminar un producto del carrito
    @Override
    public void eliminateProductFromCart(String productId) {
        Validator.validateProductID(productId);

        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(cart::deleteProduct);
    }

    // Método para eliminar todos los productos del carrito
    @Override
    public void eliminateAllProducts() {
        cart.deleteAllProducts();
    }

    // Método para modificar la cantidad de un producto del carrito
    @Override
    public void modifyQuantity(String productId, int quantity) {
        Validator.validateProductID(productId);
        Validator.validateQuantity(quantity);

        cart.getItems().stream()
                .map(ItemCart::getProduct)
                .filter(p -> p.getId().equals(productId))
                .findFirst().ifPresent(product -> cart.modifyProduct(product, quantity));
    }

    // Método para calcular el total del carrito
    @Override
    public double calculateTotal() {
        return cart.calculateTotal();
    }

    // Método para obtener el carrito
    @Override
    public Cart getCart() {
        return cart;
    }
}
