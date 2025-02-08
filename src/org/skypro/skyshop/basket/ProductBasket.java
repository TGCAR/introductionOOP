package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;

    public ProductBasket() {
        this.products = new Product[10];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public int getSpecialCount() {
        int count = 0;
        for (int i = 0; i < productCount; i++) {
            if (products[i].isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public void printBasketContents() {
        System.out.println("Содержимое корзины:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i]);
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }
}