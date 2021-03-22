package com.lynx.explore.array2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wbc
 * @date 2020/7/15 19:17
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/231/apply-basic-algorithm-thinking/959/
 */
public class FindKthLargest {

    //	方法一：堆排序
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //	方法二：快排
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int l, int h, int k) {
        if (h <= l) {
            return nums[h];
        }
        int p = partition(nums, l, h);
        if (p == nums.length - k) {
            return nums[p];
        } else if (p > nums.length - k) {
            return quickSort(nums, l, p - 1, k);
        } else {
            return quickSort(nums, p + 1, h, k);
        }
    }

    private int partition(int[] nums, int l, int h) {
        int i = l;
        int j = h + 1;
        int r = new Random().nextInt(h - l) + l;
        int v = nums[r];
        swap(nums, l, r);
        while (true) {
            while (nums[++i] < v && i != h) ;
            while (nums[--j] > v && j != l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4, 2};
        int kthLargest = f.findKthLargest2(nums, 7);
        System.out.println(kthLargest);
//		f.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

}
