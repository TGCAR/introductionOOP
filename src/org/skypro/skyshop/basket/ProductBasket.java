package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    private final Map<String, List<Product>> productsMap = new TreeMap<>();

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        return productsMap.remove(name.toLowerCase()) != null ?
                new ArrayList<>(productsMap.remove(name)) :
                Collections.emptyList();
    }

    public void printBasketContents() {
        System.out.println("Содержимое корзины:");
        productsMap.forEach((name, products) ->
                products.forEach(System.out::println)
        );
    }

    public List<Product> getProducts() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public void printBasket() {

    }
}
