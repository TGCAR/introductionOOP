package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.DiscountedProduct;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;
import java.util.Objects;


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
