package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        this.name = name;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть null или пустой строкой");
        }
    }

    public String getName() {
        return name;
    }

    public String getBaseName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

}
