package org.skypro.skyshop.product;

public class Product {
    private final String name;
    private final int price;
//    private final int price;

    // Конструктор для инициализации полей
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Геттер для получения названия продукта
    public String getName() {
        return name;
    }

    // Геттер для получения стоимости продукта
    public int getPrice() {
        return price;
    }

    // Пример использования
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 100);
        System.out.println("Продукт: " + apple.getName() + ", Стоимость: " + apple.getPrice());
    }
}
