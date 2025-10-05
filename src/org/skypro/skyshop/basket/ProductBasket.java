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
        int totalPrice = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public int countSpecials() {
        int count = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printBasket() {
        System.out.println("___________________ Продукты в корзине: ___________________");
        if (basket.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }

        for (Map.Entry<String, List<Product>> entry : basket.entrySet()) {
            String name = entry.getKey();
            List<Product> products = entry.getValue();
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }

        System.out.println("Итого: " + getPriceOfBasket());
        System.out.println("Количество специальных товаров: " + countSpecials());
    }

    public boolean findProductInBasket(String productName) {
        if (basket.containsKey(productName)) {
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
        List<Product> removedProducts = basket.remove(name);
        if (removedProducts == null) {
            removedProducts = new ArrayList<>();
        }
        return removedProducts;
    }

    private int getTotalProductCount() {
        int count = 0;
        for (List<Product> products : basket.values()) {
            count += products.size();
        }
        return count;
    }

}
