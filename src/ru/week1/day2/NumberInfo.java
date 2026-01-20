package ru.week1.day2;

import java.util.Locale;
import java.util.Scanner;

public class NumberInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int number;
        System.out.println("Введите целое число: ");

        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Введите целое число: ");
                scanner.next();
            }
        }
        while (true) {
            if (number == 0) {
                System.out.println("Нуль");
                break;
            } else if (number < 0) {
                System.out.println("Число отрицательное");
                break;
            } else if (number > 0) {
                System.out.println("Число положительное");
                break;
            } else {
                System.out.println("Введите число: ");
                continue;
            }
        }
        if (number % 2 == 0) {
            System.out.println("Число четное");
        } else if (number % 2 != 0) {
            System.out.println("Число нечетное");
        } else {
            System.out.println("Невозможно определить");
        }
    }
}

