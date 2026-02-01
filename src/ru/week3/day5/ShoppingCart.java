package ru.week3.day5;

import ru.week3.day3.Product;

import java.util.ArrayList;

public class ShoppingCart {

    private final ArrayList<Product> items = new ArrayList<>();

    public void addItem(String product, int quantity) {
        if (product == null || product.isBlank()) return;
        if (quantity <= 0) return;

        items.add(new Product(product, quantity));
    }
    public void removeItem(String productName) {
        if (productName == null) return;

        for (Product f : items) {
            if (f.getName() == productName) {
                items.remove(f.getName());
            } else {
                System.out.println("Удалять нечего");
            }
        }
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Product f : items) {
            sum += f.getBasePrice();
        }
        return sum;
    }

    public void displayCart() {
        int i = 1;
        for (Product f : items) {
            System.out.println(i++ + ". " + f.getName() + " " + f.getBasePrice());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Prod1", 12);
        cart.addItem("Prod2", 12);
        cart.addItem("Prod3", 12);
        cart.addItem("Prod4", 12);
        cart.addItem("Prod5", 12);
        cart.addItem("Prod6", 12);
        System.out.println(cart.getTotalPrice());
        cart.displayCart();
    }
}
