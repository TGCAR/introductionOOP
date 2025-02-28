package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;


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

        // Создаем статьи
        Article article1 = new Article("Как выбрать телевизор", "Советы по выбору телевизора...");
        Article article2 = new Article("Польза молока", "Молоко полезно для здоровья...");

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары и статьи в поисковый движок
        searchEngine.add(new SimpleProduct("Молоко", 120));
        searchEngine.add(new DiscountedProduct("Телевизор", 50000, 15));
        searchEngine.add(new FixPriceProduct("Соль"));
        searchEngine.add(new DiscountedProduct("Хлеб", 60, 10));
        searchEngine.add(new FixPriceProduct("Сахар"));
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрируем поиск
        System.out.println("\nРезультаты поиска по запросу 'телевизор':");
        Searchable[] results = searchEngine.search("телевизор");
        printSearchResults(results);

        System.out.println("\nРезультаты поиска по запросу 'молоко':");
        results = searchEngine.search("молоко");
        printSearchResults(results);

        System.out.println("\nРезультаты поиска по запросу 'сахар':");
        results = searchEngine.search("сахар");
        printSearchResults(results);

    }

    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("> " + result.getStringRepresentation());
            }
        }
    }
}
