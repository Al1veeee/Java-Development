package ru.week1.day3;

import java.util.Locale;
import java.util.Scanner;

public class SumToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int zero = 0;
        int sum = 0;

        System.out.print("Введите число N: ");
        int a = scanner.nextInt();
        while (a != zero) {
            sum += a;
            a--;
        }
        System.out.println("Ваше число: " + sum);
    }
}
