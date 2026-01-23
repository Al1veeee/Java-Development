package ru.week1.day5;

public class SecondMax {
    public static void main(String[] args) {
        int arr[] = {10, 5, 8, 20, 3, 18};
        int max = 0;
        int second_max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (second_max < arr[i] && arr[i] != max) {
                second_max = arr[i];
            }
        }
        System.out.print("Массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nМаксимальное значение: " + max);
        System.out.println("Второе максимальное: " + second_max);
    }
}