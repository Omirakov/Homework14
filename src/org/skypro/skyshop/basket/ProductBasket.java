package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {

    private List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
        if (basket.size() < 5) {
            basket.add(product);
            System.out.println("Товар: " + product.getName() + " добавлен в корзину!");
        }
    }

    public int getPriceOfBasket() {
        int totalPrice = 0;
        for (Product product : basket) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public int countSpecials() {
        int count = 0;
        for (Product product : basket) {
            if (product.isSpecial()) {
                count++;
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
        for (Product product : basket) {
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + getPriceOfBasket());
        System.out.println("Количество специальных товаров: " + countSpecials());
    }

    public boolean findProductInBasket(String productName) {
        for (Product product : basket) {
            if (productName.equals(product.getName())) {
                System.out.println("Товар: " + product.getName() + " найден в корзине");
                return true;
            }
        }
        System.out.println("Товар: " + productName + " не найден в корзине");
        return false;
    }

    public void removeBasket() {
        System.out.println("Корзина очищена!");
        basket.clear();
    }

    public List<Product> removeProductInBasket(String name) {
        List<Product> removedProducts = new ArrayList<>();

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove();
                removedProducts.add(product);
            }
        }
        return removedProducts;
    }

}
