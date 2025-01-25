package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Создание продуктов
        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 150);
        Product orange = new Product("Апельсин", 200);
        Product pineapple = new Product("Ананас", 300);
        Product grape = new Product("Виноград", 250);
        Product melon = new Product("Дыня", 400);

        // 1. Добавление продукта в корзину
        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.printBasketContents();

        // 2. Добавление продукта в заполненную корзину, в которой нет свободного места
        System.out.println("\nПопытка добавить больше продуктов, чем возможно:");
        basket.addProduct(pineapple);
        basket.addProduct(grape);
        basket.addProduct(melon); // Это должно вывести сообщение о том, что корзина заполнена
        basket.printBasketContents();

        // 3. Печать содержимого корзины с несколькими товарами
        System.out.println("\nСодержимое корзины:");
        basket.printBasketContents();

        // 4. Получение стоимости корзины с несколькими товарами
        System.out.println("Стоимость корзины: " + basket.getTotalPrice());

        // 5. Поиск товара, который есть в корзине
        System.out.println("\nПоиск товара в корзине:");
        System.out.println("Продукт Банан в корзине: " + basket.hasProduct("Банан"));

        // 6. Поиск товара, которого нет в корзине
        System.out.println("Продукт Дыня в корзине: " + basket.hasProduct("Дыня"));

        // 7. Очистка корзины
        System.out.println("\nОчистка корзины:");
        basket.clearBasket();
        basket.printBasketContents();

        // 8. Печать содержимого пустой корзины
        System.out.println("\nСодержимое пустой корзины:");
        basket.printBasketContents();

        // 9. Получение стоимости пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // 10. Поиск товара по имени в пустой корзине
        System.out.println("\nПоиск товара в пустой корзине:");
        System.out.println("Продукт Банан в корзине: " + basket.hasProduct("Банан"));
    }
}
