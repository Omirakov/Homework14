package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getType();

    String getArticlesName();

    default String getBaseName() {
        return null;
    }

}
