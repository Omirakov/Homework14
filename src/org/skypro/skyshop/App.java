package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;


public class App {

    public static void separator() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println();

    }


    public static void main(String[] args) {

        SimpleProduct apple = new SimpleProduct("Apple", 150);
        SimpleProduct banana = new SimpleProduct("Banana", 200);
        DiscountedProduct orange = new DiscountedProduct("Orange", 250, 50);
        DiscountedProduct grape = new DiscountedProduct("Grape", 300, 35);
        FixPriceProduct strawsberry = new FixPriceProduct("Strawsberry");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        separator();

        basket.addProduct(banana);
        separator();

        basket.addProduct(orange);
        separator();

        basket.addProduct(grape);
        separator();

        basket.addProduct(strawsberry);
        separator();

        basket.addProduct(apple);
        separator();

        basket.printBasket();
        separator();

        System.out.println(basket.getPriceOfBasket());
        separator();

        basket.findProductInBasket("Apple");
        separator();

        basket.findProductInBasket("Tomato");
        separator();

        basket.removeBasket();
        separator();

        basket.printBasket();
        separator();

        System.out.println(basket.getPriceOfBasket());
        separator();

        basket.findProductInBasket("Apple");
        separator();

    }


}
