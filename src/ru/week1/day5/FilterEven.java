package ru.week1.day5;

public class FilterEven {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int count = 0;

        // Считаем count для указания длины нового массива
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }

        // Новый массив с размером четных чисел
        int[] chet_nums = new int[count];

        int index = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                chet_nums[index++] = num;
            }
        }
        for (int i = 0; i < chet_nums.length; i++) {
            System.out.print(chet_nums[i] + " ");
        }
    }
}
