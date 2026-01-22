package ru.week1.day4;

import java.util.Arrays;

public class NewArraywithEndsofTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {50, -20, 0};
        int[] arr2 = {5, -50, 10};
        int[] smarr = new int[2];

        int j = 0;
        int i = arr2.length-1;

        smarr[0] = arr1[j];
        smarr[1] = arr2[i];

        for (int num : smarr) {
            System.out.print(num + " ");
        }
        // Решение:
        int[] array_new = {arr1[0], arr2[2]};
        System.out.println(Arrays.toString(array_new));
    }
}
// 77. New Array with Ends of Two Arrays
// https://www.w3resource.com/java-exercises/basic/index.php