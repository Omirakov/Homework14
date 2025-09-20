package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String query) {
        super("По запросу: " + query + ", ничего не найдено!");
    }
}
