package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final int FIX_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getArticlesName() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
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
