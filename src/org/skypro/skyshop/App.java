package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.Objects;


public class App {
    public static void main(String[] args) {
        // Создаем движок поиска ДО использования
        SearchEngine engine = new SearchEngine(10); // <-- Объявление здесь
        // Демонстрация проверок
        try {
            new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Телевизор", -100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Добавляем разные типы товаров
        basket.addProduct(new SimpleProduct("Молоко", 120));
        basket.addProduct(new DiscountedProduct("Телевизор", 50000, 15));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new DiscountedProduct("Хлеб", 60, 10));
        basket.addProduct(new FixPriceProduct("Сахар"));

        // Выводим содержимое корзины
        System.out.println("=".repeat(40));
        basket.printBasketContents();

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары в поисковый движок
        Arrays.stream(basket.getProducts())
                .forEach(searchEngine::add);

        // Добавляем статьи
        searchEngine.add(new Article("Выбор телевизора", "Советы по выбору LED телевизора"));
        searchEngine.add(new Article("Польза молока", "Молоко содержит кальций и витамины"));


        // Демонстрируем поиск
        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "телевизор");

        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "молоко");

        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "сахар");

        try {
            Searchable bestMatch = engine.findBestMatch("телевизор");
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Поиск несуществующего элемента
        try {
            engine.findBestMatch("смартфон");
        } catch (BestResultNotFound e) {
            System.out.println("\n[Ошибка поиска] " + e.getMessage());
        }
    }

    private static void printSearchResults(SearchEngine engine, String query) {
        System.out.println("Результаты поиска по запросу '" + query + "':");
        Arrays.stream(engine.search(query))
                .filter(Objects::nonNull)
                .forEach(item ->
                        System.out.println("• " + item.getStringRepresentation())
                );

    }
}
