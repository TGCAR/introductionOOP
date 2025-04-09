package org.skypro.skyshop.search;

import org.skypro.skyshop.exception.BestResultNotFound;

import static java.awt.SystemColor.text;

public class SearchEngine {
    private final Searchable[] searchables;
    private int index;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.index = 0;
    }

    public void add(Searchable searchable) {
        if (index < searchables.length) {
            searchables[index++] = searchable;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int count = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[count++] = searchable;
                if (count == 5) {
                    break;
                }
            }
        }

        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchables) {
            if (item == null) continue;

            int count = countOccurrences(item.getSearchTerm(), query);
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
