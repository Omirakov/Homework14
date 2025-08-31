package org.skypro.skyshop.product;


public class SimpleProduct extends Product {


    int price;


    public SimpleProduct(String name, int price) {

        super(name);
        this.price = price;

    }


    @Override
    public String getName() {

        return super.getName();

    }


    @Override
    public int getPrice() {

        return price;

    }


    @Override
    public String toString() {

        return getName() + ": " + getPrice();

    }


    @Override
    public boolean isSpecial() {

        return false;

    }


}