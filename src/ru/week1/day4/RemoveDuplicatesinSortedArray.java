package ru.week1.day4;

public class RemoveDuplicatesinSortedArray {
    public static int RemoveDublicates(int[] nums) {
        int k = 1;
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 6, 7, 7};
        int unique = RemoveDublicates(nums);

        for (int i = 0; i < unique; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
// Remove Duplicates in Sorted Array
// https://www.w3resource.com/java-exercises/basic/index.php