package org.example.services;

import org.example.models.Product;
import org.example.validation.Validator;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        Validator.validateProduct(product);

        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        Validator.validateProductID(id);

        return products.get(id);
    }

    @Override
    public void deleteProduct(String id) {
        Validator.validateProductID(id);

        products.remove(id);
    }
}
