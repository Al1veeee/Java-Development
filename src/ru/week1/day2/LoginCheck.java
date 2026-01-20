package ru.week1.day2;

import java.util.Scanner;
import java.util.Locale;

public class LoginCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String CorrectLogin = "admin";
        String CorrectPassword = "pass123";

        while (true) {
            System.out.println("Введите логин: ");
            String Login = scanner.nextLine();

            System.out.println("Введите пароль: ");
            String Password = scanner.nextLine();

            if ((Login.equals(CorrectLogin)) && (Password.equals(CorrectPassword))) {
                System.out.println("Добро пожаловать! " + Login);
                break;
            } else {
                System.out.println("Неправильный логин или пароль... Попробуй еще раз");
                continue;
            }
        }
    }
}
