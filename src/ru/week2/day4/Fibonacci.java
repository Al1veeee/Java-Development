package ru.week2.day4;

public class Fibonacci {

    public static int fibonacci(int n) {

        // Последовательность Фибоначчи (0, 1, 1, 2, 3, 5, 8...)

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int F0 = 0;
        int F1 = 1;

        for (int i = 2; i <= n; i++) {  // i = 2, потому что начинаем с 3 элемента, тк он равен сумме 1 и 2.
            int next = F0 + F1;
            F0 = F1; // 0 = 1
            F1 = next; // 1 = 1
        }
        return F1;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }
}
