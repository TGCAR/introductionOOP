package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    // Метод подсчета общей стоимости через Stream API
    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void addProduct(Product product) {
        String nameKey = product.getName().toLowerCase(); // Нормализация ключа
        productsMap.computeIfAbsent(nameKey, k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        String nameKey = name.toLowerCase(); // Нормализация ключа
        List<Product> removed = productsMap.getOrDefault(nameKey, new ArrayList<>());
        productsMap.remove(nameKey);
        return new ArrayList<>(removed);
    }

    // Метод вывода содержимого корзины через Stream API
    public void printBasketContents() {
        System.out.println("Содержимое корзины:");
        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    // Подсчет специальных товаров через Stream API
    private long getSpecialCount() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> getProducts() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public void printBasket() {

    }
}
