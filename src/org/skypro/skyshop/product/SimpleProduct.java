package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public String getArticlesName() {
        return super.getArticlesName();
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getArticlesName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getBaseName() {
        return getArticlesName();
    }

}