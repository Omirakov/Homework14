package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {

    public static void separator() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println();
    }

    public static void main(String[] args) {

        try {
            FixPriceProduct map = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            SimpleProduct pen = new SimpleProduct("Pen", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            DiscountedProduct corn = new DiscountedProduct("Corn", 750, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        SimpleProduct banana = new SimpleProduct("Banana", 200);
        DiscountedProduct orange = new DiscountedProduct("Orange", 250, 50);
        DiscountedProduct grape = new DiscountedProduct("Grape", 300, 25);
        FixPriceProduct strawsberry = new FixPriceProduct("Strawsberry");
        SimpleProduct magazine = new SimpleProduct("MAD", 1200);
        FixPriceProduct newspaper = new FixPriceProduct("New York Times");
        DiscountedProduct coffee = new DiscountedProduct("Jacobs Monarch", 250, 30);
        Article alligators = new Article("Alligators", "Alligators are large, crocodile-like...");
        Article warmUp = new Article("Morning warm-up", "1. Stretching and circular movements...");

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(grape);
        searchEngine.add(strawsberry);
        searchEngine.add(magazine);
        searchEngine.add(newspaper);
        searchEngine.add(coffee);
        searchEngine.add(alligators);
        searchEngine.add(warmUp);

        separator();

        try {
            Searchable best = searchEngine.findBestMatch("Banana");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = searchEngine.findBestMatch("Alligators");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = searchEngine.findBestMatch("Apple");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = searchEngine.findBestMatch("");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displaySearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println("Название: " + result.getBaseName() + ", Описание: " + result.getType());
            }
        }
    }

}
