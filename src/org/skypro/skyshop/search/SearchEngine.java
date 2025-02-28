package org.skypro.skyshop.search;

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
}
