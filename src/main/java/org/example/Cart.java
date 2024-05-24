package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<ItemCart> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<ItemCart> getItems() {
        return items;
    }


    // Agregar product/s al carrito
    public void addProduct(Product product, int cantidad){
        // Iterar sobre la lista en memoria de productos
        for (ItemCart item : items) {
            // Si se encuentra el product en la lista, se suma n cantidad a dicho product en la lista
            if (item.getProduct().equals(product)) {
                item.setQuantity(item.getQuantity() + cantidad);
                return;
            }
        }

        // En caso de no encontrar el product en la lista, se agrega dicho product
        items.add(new ItemCart(product, cantidad));
    }

    // Eliminar productos del carrito
    public void deleteProduct(Product product){
        // Remover en lista items el product enviado por parámetro
        items.removeIf(item -> item.getProduct().equals(product));
    }

    // Modificar la cantidad de product sen el carrito
    public void modifyProduct(Product product, int quantity){
        for (ItemCart item : items){
            // Condicional buscando si el item i es igual al product enviado por parámetro
            if (item.getProduct().equals(product)){
                item.setQuantity(quantity);
                return;
            }
        }
    }

    // Calcular el total de la compra
    public double calculateTotal(){
        double total = 0;

        // Iterando en lista de items
        for (ItemCart item : items){
            // Sumando el total de los subTotales en los items del carrito
            total += item.calculateSubTotal();
        }

        return total;
    }
}
