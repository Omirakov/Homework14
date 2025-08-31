package org.skypro.skyshop.product;


public class DiscountedProduct extends Product {


    int basePrice;
    int discount;


    public DiscountedProduct(String name, int basePrice, int discount) {

        super(name);
        this.basePrice = basePrice;
        this.discount = discount;

    }


    @Override
    public int getPrice() {

        return basePrice - (basePrice * discount / 100);

    }


    @Override
    public String toString() {

        return getName() + ": " + getPrice() + "(СКИДКА: " + discount + "%)";

    }

    @Override
    public boolean isSpecial() {

        return true;

    }


}
