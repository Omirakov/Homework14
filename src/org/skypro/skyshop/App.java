package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

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

        SearchEngine searchEngine = new SearchEngine(10);

        SimpleProduct magazine = new SimpleProduct("MAD", 1200);
        FixPriceProduct newspaper = new FixPriceProduct("New York Times");
        DiscountedProduct coffee = new DiscountedProduct("Jacobs Monarch", 250, 30);
        Article alligators = new Article("Alligators", "Alligators are large, crocodile-like...");
        Article warmUp = new Article("Morning warm-up", "1. Stretching and circular movements...");

        searchEngine.add(magazine);
        searchEngine.add(newspaper);
        searchEngine.add(coffee);
        searchEngine.add(alligators);
        searchEngine.add(warmUp);

        System.out.println("Поиск по запросу warm-up");
        displaySearchResults(searchEngine.search("warm-up"));
        separator();

        System.out.println("Поиск по запросу New York Times");
        displaySearchResults(searchEngine.search("New York Times"));
        separator();

        System.out.println("Поиск по запросу MAD");
        displaySearchResults(searchEngine.search("MAD"));
        separator();

        System.out.println("Поиск по запросу Alligators");
        displaySearchResults(searchEngine.search("Alligators"));
        separator();

        System.out.println("Поиск по запросу Jacobs Monarch");
        displaySearchResults(searchEngine.search("Jacobs Monarch"));
        separator();
    }

    private static void displaySearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("Название: " + result.getBaseName() + ", Описание: " + result.getType());
            }
        }
    }

}
