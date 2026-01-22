package ru.week1.day4;

public class ArrayStats {
    public static void main(String[] args) {
        int[] numbers = {3, 10, -5, 0, 7, 21};
        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];
        int half = 0;

        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
            sum += num;
            if (num < min) {
                min = num;
            }
            half = sum/numbers.length;
        }
        System.out.println("Сумма всех элементов массива: " + sum + "\nМаксимальное значение: " + max +
                "\nМинимальное значение: " + min + "\nСреднее значение: " + half);
    }
}
