package ru.week2.day4;

public class SumNumbers {
    public static int sunNumbers(int n) {
        if (n <= 1) {
            return 1;
        }
        return n + sunNumbers(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sunNumbers(5));
    }
}
