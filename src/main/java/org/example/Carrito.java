package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private final List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public List<ItemCarrito> getItems() {
        return items;
    }


    // Agregar producto/s al carrito
    public void agregarProducto(Producto producto, int cantidad){
        // Iterar sobre la lista en memoria de productos
        for (ItemCarrito item : items) {
            // Si se encuentra el producto en la lista, se suma n cantidad a dicho producto en la lista
            if (item.getProducto().equals(producto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }

        // En caso de no encontrar el producto en la lista, se agrega dicho producto
        items.add(new ItemCarrito(producto, cantidad));
    }

    // Eliminar productos del carrito
    public void eliminarProducto(Producto producto){
        // Remover en lista items el producto enviado por parámetro
        items.removeIf(item -> item.getProducto().equals(producto));
    }

    // Modificar la cantidad de producto sen el carrito
    public void modificarProducto(Producto producto, int cantidad){
        for (ItemCarrito item : items){
            // Condicional buscando si el item i es igual al producto enviado por parámetro
            if (item.getProducto().equals(producto)){
                item.setCantidad(cantidad);
                return;
            }
        }
    }

    // Calcular el total de la compra
    public double calcularTotal(){
        double total = 0;

        // Iterando en lista de items
        for (ItemCarrito item : items){
            // Sumando el total de los subTotales en los items del carrito
            total += item.calcularSubTotal();
        }

        return total;
    }
}
