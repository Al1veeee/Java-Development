package ru.week1.day2;

import java.util.Scanner;
import java.util.Locale;

public class AgeCategory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Введите ваш возраст: ");
        int age = scanner.nextInt();

        if (age < 13) {
            System.out.print("Категория: Ребенок");
        } else if (age <= 17) {
            System.out.print("Категория: Подросток");
        } else if (age < 64) {
            System.out.print("Категория: Взрослый");
        } else if (age >= 65) {
            System.out.print("Категория: Пенсионер");
        } else {
            System.out.println("Пишите сколько вам лет");
        }
    }
}
