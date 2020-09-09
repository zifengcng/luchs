package com.luchs.java.sort;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/9/9
 */
public class QuickSort {

    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int j = partition(nums, l, r);
        sort(nums, l, j - 1);
        sort(nums, j + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int i = l;
        int j = r + 1;
        int v = nums[l];
        while (true) {
            while (nums[++i] < v && i != r) ;
            while (nums[--j] > v && j != l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int select(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int j = partition(nums, l, r);
            if (j == k) {
                return nums[j];
            } else if (j < k) {
                l = j + 1;
            } else {
                r = j - 1;
            }
        }
        return nums[k];
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {1, 2, 4, 6, 4, 8, 2, 1, 9};
        quickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
        int[] ints = {1, 4, 2, 6, 7, 3, 5};
        System.out.println(quickSort.select(ints, 0));
    }
}
