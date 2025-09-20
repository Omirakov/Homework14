package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getType();

    String getName();

    default String getBaseName() {
        return null;
    }

}
