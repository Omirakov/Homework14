package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        if (getTotalProductCount() < 5) {
            basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
            System.out.println("Товар: " + product.getName() + " добавлен в корзину!");
        }
    }

    public int getPriceOfBasket() {
        return basket.values().stream().flatMap(List::stream).mapToInt(Product::getPrice).sum();
    }

    public int countSpecials() {
        return basket.values().stream().flatMap(List::stream).filter(Product::isSpecial).mapToInt(p -> 1).sum();
    }

    public void printBasket() {
        System.out.println("___________________ Продукты в корзине: ___________________");
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }

        basket.values().stream().flatMap(List::stream).forEach(System.out::println);

        System.out.println("Итого: " + getPriceOfBasket());
        System.out.println("Количество специальных товаров: " + countSpecials());
    }

    public boolean findProductInBasket(String productName) {
        boolean found = basket.containsKey(productName);
        if (found) {
            System.out.println("Товар: " + productName + " найден в корзине");
            return true;
        } else {
            System.out.println("Товар: " + productName + " не найден в корзине");
            return false;
        }
    }

    public void removeBasket() {
        System.out.println("Корзина очищена!");
        basket.clear();
    }

    public List<Product> removeProductInBasket(String name) {
        return Optional.ofNullable(basket.remove(name)).orElse(Collections.emptyList());
    }

    private int getTotalProductCount() {
        return basket.values().stream().mapToInt(List::size).sum();
    }

}
