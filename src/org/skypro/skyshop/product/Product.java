package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    // Конструктор для инициализации полей
    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
    }

    // Геттер для получения названия продукта
    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    // Геттер для получения стоимости продукта
    public abstract int getPrice();

    // Метод для проверки, является ли товар специальным
    public abstract boolean isSpecial();
}
