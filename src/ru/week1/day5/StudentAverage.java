package ru.week1.day5;

import java.util.Scanner;
import java.util.Locale;

public class StudentAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int count = 0;
        int number;
        int sum = 0;

        System.out.print("Сколько оценок? ");
        count = scanner.nextInt();
        int nums[] = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Введите оценку: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    nums[i] = number;
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int medium = sum/count;
        System.out.println("Средний балл: " + medium);
        if (medium >= 90) {
            System.out.println("Категория: Отличник");
        } else if (medium >= 75) {
            System.out.println("Категория: Хорошист");
        } else if (medium >= 60) {
            System.out.println("Категория: Удовлетворительно");
        } else {
            System.out.println("Категория: Нужно подтянуться");
        }
    }
}
