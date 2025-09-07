package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getArticlesName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getArticlesName();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

}
