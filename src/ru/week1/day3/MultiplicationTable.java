package ru.week1.day3;

public class MultiplicationTable {
    public static void main(String[] args) {
        int num1 = 1;
        for (int j = 1; j <= 10; j++) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(num1 + " x " + i + " = " + num1 * i + " | ");
            }
            System.out.println();
            num1++;
        }
    }
}
