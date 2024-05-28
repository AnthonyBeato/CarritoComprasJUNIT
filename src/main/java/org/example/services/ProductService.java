package org.example.services;

import org.example.models.Product;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(String id);
    void deleteProduct(String id);
}
