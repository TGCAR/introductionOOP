package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items = new TreeSet<>(new SearchableComparator());

    // Добавление элемента в поисковый индекс
    public void add(Searchable item) {
        items.add(item); // Заменяем put() на add() для Set
    }

    // Поиск по подстроке (возвращает отсортированный Set)
    public Set<Searchable> search(String query) {
        final String lowerQuery = query.toLowerCase();
        return items.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(() ->
                        new TreeSet<>(new SearchableComparator())
                ));
    }

    // Поиск лучшего совпадения по количеству вхождений
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        String lowerQuery = query.toLowerCase();

        for (Searchable item : items) { // Итерация по Set напрямую
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), lowerQuery);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }
        return bestMatch;
    }

    // Подсчет количества вхождений подстроки
    private int countOccurrences(String text, String query) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(query, index)) != -1) {
            count++;
            index += query.length();
        }
        return count;
    }
}