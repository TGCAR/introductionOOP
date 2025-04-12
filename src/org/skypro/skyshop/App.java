package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        // Проверка валидации товаров
        validateProducts();

        // Создание и настройка корзины
        ProductBasket basket = createBasketWithProducts();
        removeProductsDemo(basket);

        // Настройка поискового движка
        SearchEngine searchEngine = configureSearchEngine(basket);

        // Демонстрация поиска
        demonstrateSearch(searchEngine);

        // Поиск лучших совпадений
        demonstrateBestMatch(searchEngine);
    }

    private static void validateProducts() {
        try {
            new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Телевизор", -100, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
    }

    private static ProductBasket createBasketWithProducts() {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Молоко", 120));
        basket.addProduct(new DiscountedProduct("Телевизор", 50000, 15));
        basket.addProduct(new FixPriceProduct("Соль"));
        basket.addProduct(new DiscountedProduct("Хлеб", 60, 10));
        basket.addProduct(new FixPriceProduct("Сахар"));
        return basket;
    }

    private static void removeProductsDemo(ProductBasket basket) {
        List<Product> removed = basket.removeProductsByName("Молоко");
        System.out.println("\nУдаленные товары: " + removed);
        basket.printBasket();
    }

    private static SearchEngine configureSearchEngine(ProductBasket basket) {
        SearchEngine searchEngine = new SearchEngine();

        basket.getProducts().stream()
                .filter(Objects::nonNull)
                .forEach(searchEngine::add);

        searchEngine.add(new Article("Выбор телевизора", "Советы по выбору LED телевизора"));
        searchEngine.add(new Article("Польза молока", "Молоко содержит кальций и витамины"));

        return searchEngine;
    }

    private static void demonstrateSearch(SearchEngine searchEngine) {
        printSearchResults(searchEngine, "телевизор");
        printSearchResults(searchEngine, "молоко");
        printSearchResults(searchEngine, "сахар");
    }

    private static void demonstrateBestMatch(SearchEngine searchEngine) {
        try {
            Searchable bestMatch = searchEngine.findBestMatch("телевизор");
            System.out.println("\nЛучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            searchEngine.findBestMatch("смартфон");
        } catch (BestResultNotFound e) {
            System.out.println("\nОшибка поиска: " + e.getMessage());
        }
    }

    private static void printSearchResults(SearchEngine engine, String query) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Результаты поиска по запросу '" + query + "':");

        engine.search(query).stream()
                .map(item -> "• " + item.getStringRepresentation())
                .forEach(System.out::println);
    }
}