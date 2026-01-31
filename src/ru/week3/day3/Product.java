package ru.week3.day3;

public class Product {
    private String name;
    private double basePrice;
    private double discountPercent;

    public Product(String name, double basePrice)  {
        this.name = name;
        this.basePrice = basePrice;
    }

    public double getDiscountedPrice() {
        return basePrice - (basePrice/100 * discountPercent);
    }

    public void applyDiscount(double percent) {
        this.discountPercent = percent;
    }

    public static void main(String[] args) {
        Product prod = new Product("Карта", 1000);

        System.out.println(prod.getDiscountedPrice());
        prod.applyDiscount(10);
        System.out.println(prod.getDiscountedPrice());

    }

}
