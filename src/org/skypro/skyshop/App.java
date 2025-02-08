package org.skypro.skyshop;

import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Добавляем разные типы товаров
        basket.addProduct(new SimpleProduct("Молоко", 120));
        basket.addProduct(new DiscountedProduct("Телевизор", 50000, 15));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new DiscountedProduct("Хлеб", 60, 10));
        basket.addProduct(new FixPriceProduct("Сахар"));

        // Печать содержимого корзины с несколькими товарами
        basket.printBasketContents();
    }
}
