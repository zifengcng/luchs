package com.luchs.java.sort;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/9/9
 */
public class HeapSort {

    // 1
    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            minHeapify(nums, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            minHeapify(nums, 0, i);
        }
    }

    private void minHeapify(int[] nums, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;

        if (l < size && nums[l] < nums[min]) {
            min = l;
        }
        if (r < size && nums[r] < nums[min]) {
            min = r;
        }
        if (min != i) {
            swap(nums, i, min);
            minHeapify(nums, min, size);
        }


    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {3, 1, 5, 4, 6, 2};
        heapSort.headSort3(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 2
    public void maxHeapSort(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    private void maxHeapify(int[] nums, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int max = i;
        if (l < size && nums[l] > nums[max]) {
            max = l;
        }
        if (r < size && nums[r] > nums[max]) {
            max = r;
        }
        if (max != i) {
            swap(nums, i, max);
            maxHeapify(nums, max, size);
        }
    }


    // 3
    public void headSort3(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            sink(nums, i, len);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            sink(nums, 0, i);
        }


    }

    private void sink(int[] nums, int i, int size) {
        while (2 * i < size) {
            int j = 2 * i;
            if (j + 1 < size && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[i] >= nums[j]) {
                break;
            }
            swap(nums, i, j);
            i = j;
        }
    }

}
