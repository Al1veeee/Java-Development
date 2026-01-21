package ru.week1.day3;

import java.util.Scanner;
import java.util.Locale;

public class CountEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int num;
        int x = 3;

        do {
            int chet = 0;
            int nechet = 0;
            System.out.print("Введите число: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    num = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Вводите только числа: ");
                    scanner.next();
                }
            }

            for (int i = 1; i <= num; i++) {
                if (i % 2 == 0) {
                    chet++;
                } else {
                    nechet++;
                }
            }
            System.out.println("Четных чисел: " + chet + "\nНечетных чисел: " + nechet);
            System.out.println("1. Продолжить\n" + "0. Выход");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt();
                } else {
                System.out.println("Введите число 1 или 0: ");
            }
        } while (x != 0);
    }
}

