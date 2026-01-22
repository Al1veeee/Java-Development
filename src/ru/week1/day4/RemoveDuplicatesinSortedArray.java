package ru.week1.day4;

public class RemoveDuplicatesinSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7};
        int[] new_array = new int[10];

        for (int i = 0, j = 1; i < arr.length-1; i++, j++) {
            if (arr[i] != arr[j]) {
                new_array[i] = arr[j];
            } else if (arr[i] == arr[j]) {
                new_array[i] = arr[i];
            }
        }
        for (int num : new_array) {
            System.out.print(num + " ");
        }
    }
}
// Remove Duplicates in Sorted Array
// https://www.w3resource.com/java-exercises/basic/index.php