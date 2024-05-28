package org.example.validation;

import org.example.models.Product;

public class Validator {
    public static void validateProduct(Product product){
        if (product.getName() == null || product.getName().isEmpty()){
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío");
        }
        if(product.getPrice() < 0){
            throw new IllegalArgumentException("El precio del producto no puede ser negativo");
        }
    }

    public static void validateQuantity(int quantity){
        if (quantity <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }
}


