package ru.week2.day2;

public class ConverterTemp {
    public static double celsiusToFahrenheit(double celsius) {
        double C = celsius;
        double F = C * 9/5 + 32;
        return F;
    }

    public static void main(String[] args) {
        double result = celsiusToFahrenheit(0);
        System.out.println(result);
    }
}
