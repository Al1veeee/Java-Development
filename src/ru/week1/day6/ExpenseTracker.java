package ru.week1.day6;

import java.util.Scanner;
import java.util.Locale;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        double average = 0;
        double sum = 0;
        int choice = 0;
        int day;
        int n = 30;
        double max = 0;
        double min = 0;
        double cash;
        double zero = 0;
        double[] dailyExpenses = new double[n];

        do {
            System.out.println("=== Трекер расходов ===");
            System.out.print("1. Добавить расход\n" + "2. Показать статистику\n" + "3. Выход\n" + "_______________________\n");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите день (1-30): ");
                    while (true) {
                        if (scanner.hasNextInt()) {
                            day = scanner.nextInt();
                            if (day >= 1 && day <= 30) {
                                break;
                            } else {
                                System.out.print("День 1-30: ");
                            }
                        } else {
                            System.out.print("Число: ");
                            scanner.next();
                        }
                    }
                    System.out.println("Введите сумму (Р): ");
                    while (true) {
                        if (scanner.hasNextDouble()) {
                            cash = scanner.nextDouble();
                            dailyExpenses[day - 1] = cash;
                            System.out.println("Добавлено!");
                            break;
                        } else {
                            System.out.print("Число: ");
                            scanner.next();
                        }
                    }
                    break;

                case 2:

                    // Общий расход
                    for (double num : dailyExpenses) {
                        sum += num;
                    }
                    System.out.println("Общий расход: " + sum);

                    // Средний расход
                    for (double num : dailyExpenses) {
                        average = (sum += num)/n;
                    }
                    System.out.println("Средний расход: " + average);

                    // Максимальное значение
                    for (int i = 1; i < n; i++) {
                        if (dailyExpenses[i] > dailyExpenses[i-1]) {
                            max = dailyExpenses[i];
                        }
                    }
                    System.out.println("Максимальное значение: " + max);

                    // Минимальное значение
                    for (int i = 1; i < n; i++) {
                        if (dailyExpenses[i] < dailyExpenses[i-1]) {
                            min = dailyExpenses[i];
                        }
                    }
                    System.out.println("Минимальное значение: " + min);
                    break;
            }
        } while (choice != 3);

    }
}
