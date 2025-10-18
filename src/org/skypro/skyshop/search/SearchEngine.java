package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable item) {
        items.add(item);
    }

    public SortedSet<Searchable> search(String query) {

        Comparator<Searchable> comparator = (s1, s2) -> {
            String name1 = s1.getName();
            String name2 = s2.getName();

            int lengthCompare = Integer.compare(name2.length(), name1.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }

            return name1.compareTo(name2);
        };

        return items.stream().filter(items -> items != null && items.getSearchTerm() != null && items.getSearchTerm().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
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
        String textLow = text.toLowerCase();
        String patternLow = pattern.toLowerCase();

        while (true) {
            int foundIndex = textLow.indexOf(patternLow, index);
            if (foundIndex == -1) {
                break;
            }
            count++;
            index = foundIndex + pattern.length();
        }

        return count;
    }
}
