package ru.week1.day4;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] reversed = new int[arr.length];

        for (int i = arr.length-1, j = 0; i >= 0; i--, j++) {
            reversed[j] = arr[i];
            // 0 = 4 (1 -> 5)
            // 1 = 3 (2 -> 4)
            // 2 = 2 (3 -> 3)
            // 3 = 1 (4 -> 2)
            // 4 = 0 (5 -> 1)
        }
        for (int num : reversed) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int mum : arr) {
            System.out.print(mum + " ");
        }
    }
}
