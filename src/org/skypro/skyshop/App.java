package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;


public class App {

    public static void separator() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println();

    }


    public static void main(String[] args) {

        Product apple = new Product("Apple", 150);
        Product banana = new Product("Banana", 200);
        Product orange = new Product("Orange", 250);
        Product grape = new Product("Grape", 300);
        Product strawsberry = new Product("Strawsberry", 350);

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
