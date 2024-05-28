package org.example;

import junit.framework.TestCase;
import org.example.models.ItemCart;
import org.example.models.Product;

public class ItemCartTest extends TestCase {
    public void testCalculateTotal(){
        Product product = new Product("1","Laptop Asus", 1200.0);
        ItemCart item = new ItemCart(product, 2);
        assertEquals(2400.0, item.calculateSubTotal());
    }
}
