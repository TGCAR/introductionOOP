package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final int basePrice; // Базовая цена
    private final int discount;  // Скидка в процентах (целое число от 0 до 100)

    // Конструктор для инициализации полей
    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    // Переопределенный метод getPrice с учетом скидки
    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
