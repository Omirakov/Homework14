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
            if (item != null && item.getSearchTerm().contains(query)) result[index++] = item;
            if (index == 5) {
                break;
            }
        }
        return result;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new IllegalArgumentException("Поле поискового запроса не может быть null или пустой строкой!");
        }

        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item == null) {
                continue;
            }

            String term = item.getSearchTerm();
            if (term == null) {
                continue;
            }

            int count = countOccurrences(term, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String pattern) {
        if (text == null || pattern == null || pattern.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while (true) {
            int foundIndex = text.indexOf(pattern, index);
            if (foundIndex == -1) {
                break;
            }
            count++;
            index = foundIndex + pattern.length(); // избегаем перекрытий
        }

        return count;
    }
}
