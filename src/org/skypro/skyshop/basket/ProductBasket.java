package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                removed.add(p);
                iterator.remove();
            }
        }
        return removed;
    }

    public void printBasket() {
        System.out.println("Содержимое корзины:");
        products.forEach(System.out::println);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}