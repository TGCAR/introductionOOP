package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();


    public void addProduct(Product product) {
        String productName = product.getName().toLowerCase();
        productsMap.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    public int removeProductsByName(String name) {
        String key = name.toLowerCase();
        List<Product> removedProducts = productsMap.remove(key);
        return removedProducts != null ? removedProducts.size() : 0;
    }

    public void printBasketContents() {
        System.out.println("Содержимое корзины:");
        productsMap.forEach((name, products) ->
                System.out.println(name + " x" + products.size())
        );
    }

    public void printBasket() {
        printBasketContents();
    }
}
