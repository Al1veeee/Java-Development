package ru.week1.day2;

import java.util.Scanner;
import java.util.Locale;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double number1;
        double number2;
        int pick;

        System.out.print("Введите первое число: ");
        while (true) {
            if (scanner.hasNextDouble()) {
                number1 = scanner.nextDouble();
                break;
            } else {
                System.out.print("Вводите только числа. Попробуйте ещё раз: ");
                scanner.next();
            }
        }
        System.out.print("Введите второе число: ");
        while (true) {
            if (scanner.hasNextDouble()) {
                number2 = scanner.nextDouble();
                break;
            } else {
                System.out.print("Вводите только числа. Попробуйте ещё раз: ");
                scanner.next();
            }
        }
        System.out.println("Выберите операцию: \n" +
                "1. +\n" + "2. -\n" + "3. *\n" + "4. /\n");

        System.out.print("Ваш выбор: ");
        while (true) {
            if (scanner.hasNextInt()) {
                pick = scanner.nextInt();
                break;
            } else {
                System.out.print("Вводите только числа от 1 до 4. Попробуйте еще раз: ");
                scanner.next();
            }
        }
        switch (pick) {
            case (1):
                System.out.println(number1 + number2);
                break;
            case (2):
                System.out.println(number1 - number2);
                break;
            case (3):
                System.out.println(number1 * number2);
                break;
            case (4):
                System.out.println(number1 / number2);
                break;
        }
    }
}
