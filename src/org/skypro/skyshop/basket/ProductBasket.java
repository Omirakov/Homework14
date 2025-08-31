package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;


public class ProductBasket {


    private Product[] basket = new Product[5];
    private int size = 0;


    public void addProduct(Product product) {

        if (size < basket.length) {
            basket[size++] = product;
            System.out.println("Товар: " + product.getName() + " добавлен в корзину!");

        } else {

            System.out.println("Не удалось добавить " + product.getName() + ": корзина полная!");

        }

    }


    public int getPriceOfBasket() {

        int totalPrice = 0;

        for (int i = 0; i < size; i++) {
            totalPrice += basket[i].getPrice();

        }

        return totalPrice;

    }


    public void printBasket() {

        System.out.println("___________________ Продукты в корзине: ___________________");

        if (basket == null || size == 0) {
            System.out.println("В корзине пусто!");
            return;

        }

        for (int i = 0; i < size; i++) {
            Product product = basket[i];
            System.out.println(product.getName() + ": " + product.getPrice());

        }

        System.out.println("Итого: " + getPriceOfBasket());

    }


    public boolean findProductInBasket(String productName) {

        for (int i = 0; i < size; i++) {

            if (productName.equals(basket[i].getName())) {
                System.out.println("Товар: " + basket[i].getName() + " найден в корзине");
                return true;

            }

        }

        System.out.println("Товар: " + productName + " не найден в корзине");
        return false;

    }


    public void removeBasket() {

        System.out.println("Корзина очищена!");

        for (int i = 0; i < size; i++) {
            basket[i] = null;
            size = 0;

        }

    }


}
