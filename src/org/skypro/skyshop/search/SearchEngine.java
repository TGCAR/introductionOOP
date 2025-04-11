package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final Map<String, Searchable> itemsMap = new TreeMap<>();

    // Добавление элемента в поисковый индекс
    public void add(Searchable item) {
        itemsMap.put(item.getSearchTerm().toLowerCase(), item);
    }

    // Поиск по точному совпадению (возвращает отсортированную мапу)
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        String lowerQuery = query.toLowerCase();

        itemsMap.forEach((key, item) -> {
            if (key.contains(lowerQuery)) {
                results.put(item.getSearchTerm(), item);
            }
        });
        return results;
    }

    // Поиск лучшего совпадения по количеству вхождений
    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        String lowerQuery = query.toLowerCase();

        for (Searchable item : itemsMap.values()) {
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