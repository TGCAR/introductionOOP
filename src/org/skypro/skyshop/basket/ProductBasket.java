package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, Integer> productsMap = new HashMap<>();


    public void addProduct(Product product) {
        String productName = product.getName().toLowerCase();
        productsMap.put(productName, productsMap.getOrDefault(productName, 0) + 1);
    }

    public int removeProductsByName(String name) {
        String key = name.toLowerCase();
        Integer removedCount = productsMap.remove(key);
        return removedCount != null ? removedCount : 0;
    }

    public void printBasketContents() {
        System.out.println("Содержимое корзины:");
        productsMap.forEach((name, count) ->
                System.out.println(name + " x" + count)
        );
    }

    public Map<String, Integer> getProducts() {
        return new HashMap<>(productsMap);
    }

    public void printBasket() {
        printBasketContents();
    }
}
