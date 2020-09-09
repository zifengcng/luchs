package com.luchs.java.sort;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/9/9
 */
public class MergeSort {

    private int[] aux;

    public void mergeSort(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        for (int i = l; i <= r; i++) {
            aux[i] = nums[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;
        while (k <= r) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > r) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {1, 7, 3, 4, 7, 4, 5, 8, 10, 9};
        mergeSort.mergeSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort2(int[] nums) {
        aux = new int[nums.length];

        int len = nums.length;
        for (int size = 1; size < len; size += size) {
            for (int lo = 0; lo < len - size; lo += size + size) {
                merge(nums, lo, lo + size - 1, Math.min(lo + size + size - 1, len - 1));
            }
        }
    }
}
