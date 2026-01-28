package ru.week2.day2;

public class SumofNumber {
    public static int SumOfDigits(int number) {
        int n = number;
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // Находим остаток от деления
            n /= 10; // Убираем последний элемент
        }
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfDigits(123);
        System.out.println(result);
    }
}
