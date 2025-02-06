package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {

    private final int basePrice; // Базовая цена
    private final int discount;  // Скидка в процентах (целое число от 0 до 100)

    // Конструктор для инициализации полей
    public DiscountedProduct(String name, int price, int basePrice, int discount) {
        super(name, price);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    // Геттер для получения скидки
    public int getDiscount() {
        return discount;
    }

    // Переопределенный метод getPrice с учетом скидки
    @Override
    public int getPrice() {
        // Вычисляем цену с учетом скидки
        return basePrice - (basePrice * discount / 100);
    }
}
