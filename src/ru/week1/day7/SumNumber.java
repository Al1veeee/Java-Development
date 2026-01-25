package ru.week1.day7;

public class SumNumber {
    public static void main(String[] args) {

        int number = 321;
        int sum = 0;

        String s = String.valueOf(number); // Перевод числа в строковый вид
        char[] numbers = s.toCharArray(); // [3, 2, 1]
        int[] digits = new int[numbers.length]; // Создаем целочисленный массив

        for (int i = 0; i < numbers.length; i++) {
            digits[i] = numbers[i] - '0'; // ASCII: '0' = 48
            sum += digits[i];
        }
        System.out.println(sum);
    }
}
