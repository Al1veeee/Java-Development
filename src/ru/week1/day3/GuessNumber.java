package ru.week1.day3;

import java.util.Scanner;
import java.util.Locale;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        int secret = 7;
        int choice;
        int n = 0;

        do {
            System.out.print("Угадай число от 1 до 10: ");
            choice = scanner.nextInt();
            n++;
        } while (choice != secret);
        System.out.println("Поздравляю, загаданное число: " + secret + "\nВам понадобилось " + n + " действия");
    }
}
