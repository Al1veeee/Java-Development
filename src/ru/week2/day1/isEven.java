package ru.week2.day1;

import java.util.Scanner;
import java.util.Locale;

public class isEven {
    public static int Even(int number) {
        if (number <= 0) {
            System.out.println("Некорректное значение");
        } else if (number % 2 == 0) {
            System.out.println("true");
        } else
            System.out.println("false");
        return number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int num = 0;

        System.out.println("Введите число для определения четности: ");

        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Вводите только числа");
                scanner.next();
            }
        }

        Even(num); // Вызов метода Even
    }
}
