package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Map;
import java.util.Objects;

public class App {
    public static void main(String[] args) {
        // Проверка валидации товаров
        try {
            new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            DiscountedProduct телевизор = new DiscountedProduct("Телевизор", -100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Создание корзины и добавление товаров
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Молоко", 120));
        basket.addProduct(new DiscountedProduct("Телевизор", 50000, 15));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new DiscountedProduct("Хлеб", 60, 10));
        basket.addProduct(new FixPriceProduct("Сахар"));

        // Удаление товаров по имени
        int removed = basket.removeProductsByName("Молоко");
        System.out.println("Удаленные товары: " + removed);
        basket.printBasket();

        // Создание и настройка поискового движка
        SearchEngine searchEngine = new SearchEngine();


        // Добавление статей в поисковый движок
        searchEngine.add(new Article("Выбор телевизора", "Советы по выбору LED телевизора"));
        searchEngine.add(new Article("Польза молока", "Молоко содержит кальций и витамины"));

        // Демонстрация поиска
        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "телевизор");

        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "молоко");

        System.out.println("\n" + "=".repeat(40));
        printSearchResults(searchEngine, "сахар");

        // Поиск лучшего совпадения
        try {
            Searchable bestMatch = searchEngine.findBestMatch("телевизор");
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Обработка исключения при отсутствии результатов
        try {
            searchEngine.findBestMatch("смартфон");
        } catch (BestResultNotFound e) {
            System.out.println("\n[Ошибка поиска] " + e.getMessage());
        }
    }

    private static void printSearchResults(SearchEngine engine, String query) {
        System.out.println("Результаты поиска по запросу '" + query + "':");
        Map<String, Searchable> results = engine.search(query);
        results.forEach((name, item) ->
                System.out.println("• " + item.getStringRepresentation())
        );
    }
}