package ru.week2.day3;

public class SmartCalculator {
    static private double savedValue = 0.0;
    static private String lastOperation;

    public static void add(double value) {
        savedValue += value;
        lastOperation = "+";
    }
    public static void subtract(double value) {
        savedValue -= value;
        lastOperation = "-";
    }
    public static void save(double value) {
        savedValue = value;
        lastOperation = "";
        System.out.println("Сохранено");
    }
    public static double getResult() {
        System.out.println(savedValue);
        return savedValue;
    }

    public static void main(String[] args) {
        save(10);
        getResult();
        add(20);
        getResult();
        subtract(10.1);
        getResult();
    }
}
