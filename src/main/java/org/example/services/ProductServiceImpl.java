package org.example.services;

import org.example.models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public void deleteProduct(String id) {
        products.remove(id);
    }
}
