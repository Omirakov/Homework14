package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {

    private final List<Searchable> items = new ArrayList<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String query) {
        List<Searchable> result = new ArrayList<>();

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm() != null && item.getSearchTerm().contains(query)) {
                result.add(item);
            }
        }

        Map<String, Searchable> mapResult = new LinkedHashMap<>();
        for (Searchable item : result) {
            String itemName = item.getName();
            if (itemName != null) {
                mapResult.put(itemName, item);
            }
        }
        return new TreeMap<>(mapResult);
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
            index = foundIndex + pattern.length();
        }

        return count;
    }
}
