package ru.week1.day7;

import java.util.Scanner;
import java.util.Locale;

public class DivisorsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int number;
        int count = 0;

        // Защита на ввод
        System.out.println("Введите число: ");
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Вводите только числа");
                scanner.next();
            }
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
