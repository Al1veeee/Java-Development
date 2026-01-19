package ru.week1.day1;

import java.util.Scanner;
import java.util.Locale;

public class UserInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        System.out.print("Каков ваш рост: ");
        double tall = scanner.nextDouble();

        System.out.print("Есть ли опыт в программировании? ");
        boolean tf = scanner.nextBoolean();


        System.out.println(
                "=== Информация о пользователе === \n" + "Имя: " + name + "\n" + "Возраст: " + age + "\n" + "Рост: " + tall + "\n" + "Опыт программирования: " + tf + "\n"
        );
    }
}