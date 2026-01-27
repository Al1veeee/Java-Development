package ru.week2.day1;

public class CalculatePerimeter {
    public static double calculatePerimeter(double length, double width) {
        return (2 * (length + width));
    }
    public static void main(String[] args) {
        double result = calculatePerimeter(5, 3);
        System.out.println(result);
    }
}
