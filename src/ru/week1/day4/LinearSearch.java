package ru.week1.day4;

import java.util.Locale;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        String[] names = {"Alex", "Maria", "John", "Kate"};
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String name;
        boolean found = false;
        int place = 1;

        System.out.print("Alex, " + "Maria, " + "John, " + "Kate\n" + "Введите имя: ");
        while (true) {
            if (scanner.hasNextLine()) {
                name = scanner.nextLine();
                break;
            } else {
                System.out.println("Пишите только имя: ");
                scanner.next();
            }
        }
        for (String word : names) {
            if (word.equals(name)) {
                System.out.print("Найден на позиции: " + place);
                found = true;
                break;
            } else {
                place++;
            }
        }
        if (found != true) {
            System.out.println("Неправильное имя! Попробуйте еще раз.");
            scanner.next();
        }
    }
}
