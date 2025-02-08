package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    // Конструктор для инициализации полей
    public Product(String name) {
        this.name = name;
    }

    // Геттер для получения названия продукта
    public String getName() {
        return name;
    }

    // Геттер для получения стоимости продукта
    public abstract int getPrice();

    // Метод для проверки, является ли товар специальным
    public abstract boolean isSpecial();
}
