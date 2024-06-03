package org.example.services;

import org.example.models.Product;
import org.example.validation.Validator;

import java.util.HashMap;
import java.util.Map;

// Implementación de Servicio de Producto
public class ProductServiceImpl implements ProductService{
    // Lista de productos creados en la sesión
    private final Map<String, Product> products = new HashMap<>();

    // Método para añadir un producto la lista de productos
    @Override
    public void addProduct(Product product) {
        Validator.validateProduct(product);

        products.put(product.getId(), product);
    }

    // Método para obtener un producto por su identificador
    @Override
    public Product getProductById(String id) {
        Validator.validateProductID(id);

        return products.get(id);
    }

    // Método para borrar un producto según su identificador
    @Override
    public void deleteProduct(String id) {
        Validator.validateProductID(id);

        products.remove(id);
    }
}
