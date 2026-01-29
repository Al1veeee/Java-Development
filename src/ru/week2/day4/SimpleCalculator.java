package ru.week2.day4;

import java.util.Locale;
import java.util.Scanner;

public class SimpleCalculator {

    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    public static double num1;
    public static double num2;

    public static int num;
    public static String history = "\n=== История ===\n";

    public static double simpleCalculator(int number) {

        while (true) {
            if (number < 1 || number > 6) {
                System.out.println("Ошибка! Вводите только числа от 1-6");
            } else if (number == 5) {
                System.out.println(history);
                break;
            } else if (number == 6) {
                break;
            }
            System.out.print("Введите первое число: ");
            num1 = scanner.nextDouble();
            System.out.print("Введите второе число: ");
            num2 = scanner.nextDouble();
            break;
        }

        switch (number) {
            case 1:
                return Add(num1, num2);
            case 2:
                return Subtract(num1, num2);
            case 3:
                return Multiply(num1, num2);
            case 4:
                return Divide(num1, num2);
            default: return 0;
        }
    }
    public static double Add(double a, double b) {
        history = history.concat("\nСложение чисел " + a + " и " + b);
        return a + b;
    }
    public static double Subtract(double a, double b) {
        history = history.concat("\nВычитание чисел " + a + " из " + b);
        return a - b;
    }
    public static double Multiply(double a, double b) {
        history = history.concat("\nУмножение чисел " + a + " и " + b);
        return a * b;
    }
    public static double Divide(double a, double b) {
        history = history.concat("\nДеление чисел " + a + "и" + b);
        return a / b;
    }
    public static void History() {
        System.out.println(history);
    }

    public static void main(String[] args) {
        do {
            System.out.println(
                    "\n=== Menu ===\n" + "1. Add\n" + "2. Subtract\n" + "3. Multiply\n" + "4. Divide\n" + "5. History\n" + "6. Exit\n");
            num = scanner.nextInt();
            System.out.println(simpleCalculator(num));
        } while (num != 6);
    }
}
