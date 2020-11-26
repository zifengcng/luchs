package com.luchs.sort;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/16 10:24
 * 堆排序
 */
public class MyHeapSort {

	public void minHeapSort(int[] nums) {
		int length = nums.length;
		for (int i = (length - 1) >> 1; i >= 0; i--) {
			minHeapify(nums, i, length);
		}
		for (int i = length - 1; i > 0; i--) {
			swap(nums, 0, i);
			minHeapify(nums, 0, i);
		}
	}

	private void minHeapify(int[] nums, int i, int size) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
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

	public void maxHeapSort(int[] nums) {
		int length = nums.length;
		for (int i = (length - 1) >> 1; i >= 0; i--) {
			// 不能用length-1
			maxHeapify(nums, i, length);
		}
		for (int i = length - 1; i > 0; i--) {
			swap(nums, 0, i);
			maxHeapify(nums, 0, i);
		}
	}

	private void maxHeapify(int[] nums, int i, int size) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
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

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	public static void main(String[] args) {
		MyHeapSort heapSort = new MyHeapSort();
		int[] nums = {3, 1, 2, 4};
		heapSort.maxHeapSort(nums);
		System.out.println(Arrays.toString(nums));

		heapSort.minHeapSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
