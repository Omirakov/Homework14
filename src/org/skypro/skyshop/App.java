package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class App {

    public static void separator() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println();
    }

    public static void main(String[] args) {

        separator();

        try {
            FixPriceProduct map = new FixPriceProduct("");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        separator();

        try {
            SimpleProduct pen = new SimpleProduct("Pen", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        separator();

        try {
            DiscountedProduct corn = new DiscountedProduct("Corn", 750, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        separator();

        Product banana = new SimpleProduct("Banana", 200);
        Product orange = new DiscountedProduct("Orange", 250, 50);
        Product oreo = new SimpleProduct("Oreo", 245);
        Product grape = new DiscountedProduct("Grape", 300, 25);
        Product strawsberry = new FixPriceProduct("Strawsberry");
        Product magazine = new SimpleProduct("MAD", 1200);
        Product newspaper = new FixPriceProduct("New York Times");
        Product coffee = new DiscountedProduct("Jacobs Monarch", 250, 30);
        Article alligators = new Article("Alligators", "Alligators are large, crocodile-like...");
        Article warmUp = new Article("Morning warm-up", "1. Stretching and circular movements...");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(oreo);
        basket.addProduct(orange);
        basket.addProduct(orange);
        basket.addProduct(grape);
        basket.addProduct(coffee);

        separator();

        List<Product> removed = basket.removeProductInBasket("Orange");
        System.out.println("Количество удаленных продуктов - " + removed.size() + ":");
        for (Product product : removed) {
            System.out.println(product.getName());
        }

        separator();

        basket.printBasket();

        separator();

        List<Product> removedNonProduct = basket.removeProductInBasket("Strawsberry");
        if (removedNonProduct.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст!");
        }

        separator();

        basket.printBasket();

        separator();

        SearchEngine engine = new SearchEngine();
        engine.add(banana);
        engine.add(orange);
        engine.add(grape);
        engine.add(strawsberry);
        engine.add(magazine);
        engine.add(oreo);
        engine.add(coffee);
        engine.add(alligators);
        engine.add(warmUp);

        SortedSet<Searchable> results = engine.search("M");
        for (Searchable item : results) {
            System.out.println("Результаты поиска: " + item.getSearchTerm());
        }

        separator();

        SortedSet<Searchable> results2 = engine.search("B");
        for (Searchable item : results2) {
            System.out.println("Результаты поиска: " + item.getSearchTerm());
        }

        separator();

        SortedSet<Searchable> results3 = engine.search("a");
        for (Searchable item : results3) {
            System.out.println("Результаты поиска: " + item.getSearchTerm());
        }

        separator();

        try {
            Searchable best = engine.findBestMatch("Banana");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = engine.findBestMatch("Alligators");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = engine.findBestMatch("Apple");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        separator();

        try {
            Searchable best = engine.findBestMatch("");
            System.out.println("Лучший результат: " + best.getType() + " " + best.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}
