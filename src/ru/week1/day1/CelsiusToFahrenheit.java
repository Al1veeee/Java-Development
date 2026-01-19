package ru.week1.day1;

import java.util.Scanner;
import java.util.Locale;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Введите градусы: ");
        double celsius = scanner.nextDouble();
        double fahreinheit = celsius * 9.0/5.0 + 32;
        System.out.println(celsius + "°C = " + fahreinheit + "°F");
    }
}
