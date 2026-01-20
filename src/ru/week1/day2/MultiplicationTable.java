package ru.week1.day2;

import java.util.Scanner;
import java.util.Locale;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int number;

        System.out.print("Введите число: ");

        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.print("Вводите только числа. Попробуйте еще раз: ");
                scanner.next();
            }
        }

        for (int i = 1; i < 11; i++) {
            System.out.println(number + " x " + i + " = " + number*i);
        }



    }
}
