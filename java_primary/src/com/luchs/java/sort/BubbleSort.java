package com.luchs.java.sort;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/9/9
 */
public class BubbleSort {

    public void bubbleSort(int[] nums) {
        int len = nums.length;

        boolean isSorted = false;
        for (int i = 0; i < len - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {1, 6, 4, 3, 7, 5, 8};
        bubbleSort.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
