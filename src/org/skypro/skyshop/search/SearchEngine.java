package org.skypro.skyshop.search;

public class SearchEngine {

    private final Searchable[] items;
    private int currentIndex = 0;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
        this.currentIndex = 0;
    }

    public void add(Searchable item) {
        if (currentIndex < items.length) {
            items[currentIndex++] = item;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] result = new Searchable[5];
        int index = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm().contains(query))
                result[index++] = item;
            if (index == 5) {
                break;
            }
        }
        return result;
    }

}
