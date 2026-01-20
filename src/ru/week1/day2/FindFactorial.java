package ru.week1.day2;

import java.util.Scanner;
import java.util.Locale;

public class FindFactorial {
    static int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int number;

        System.out.print("Введите число: ");
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.print("Число не может быть нулем или отрицательным. Попробуй еще раз: ");
                    continue;
                }
                break;
            } else {
                System.out.print("Вводите только числа. Попробуйте ещё раз: ");
                scanner.next();
            }
        }

        System.out.println("Число: "+ number + "\n" + "Факториал: " + factorial(number));
    }
}
