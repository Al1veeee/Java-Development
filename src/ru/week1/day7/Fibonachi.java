package ru.week1.day7;

public class Fibonachi {
    public static void main(String[] args) {

        int num1 = 0100;
        int n = 0;
        String s = String.valueOf(num1); // В строковый вид
        char[] number = s.toCharArray(); // ["1", "0", "0"]
        int[] numbers = new int[number.length]; // [_, _, _,]
        for (int i = 0, j = number.length-1; i < number.length; i++, j--) {
            numbers[i] = number[i] - '0';
            System.out.print(numbers[i] + " ");
        }
        for (int i = 0, j = number.length - 1; i < number.length / 2; i++, j--) {
            if (numbers[i] != numbers[j]) {
                System.out.print("\nЧисло " + numbers[i] + " не сходится с " + numbers[j]);
                n++;
            }
        }
        if (n != 0) {
            System.out.print("\nЧИСЛО НЕ ФИБОНАЧИ");
        } else if (numbers.length == 1) {
            System.out.print("\nЧИСЛО ФИБОНАЧИ");
        } else {
            System.out.print("\nЧИСЛО ФИБОНАЧИ");
        }
    }
}
