package ru.week2.day2;

public class FindMax {
    public static int findMax(int a, int b) {
        if (a <= b) {
            return b;
        }
        return a;
    }
    public static void main(String[] args) {
        int result = findMax(10, 20);
        System.out.println(result);
    }
}
