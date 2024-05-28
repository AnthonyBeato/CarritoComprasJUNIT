package org.example.models;

import org.example.validation.Validator;

public class ItemCart {
    private Product product;
    private int quantity;

    public ItemCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        Validator.validateQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calcular subtotal del item dependiendo el product y la cantidad
    public double calculateSubTotal(){
        return product.getPrice() * quantity;
    }
}
