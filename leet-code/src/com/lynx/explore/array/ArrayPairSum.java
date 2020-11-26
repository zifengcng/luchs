package com.lynx.explore.array;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/6/29 19:01
 * 数组拆分 I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,4,3,2]
 * <p>
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 提示:
 * <p>
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/784/
 */
public class ArrayPairSum {

	public int arrayPairSum(int[] nums) {
		quickSort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}

	private void quickSort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}

	private void sort(int[] nums, int l, int h) {
		if (h <= l) {
			return;
		}
		int j = partition(nums, l, h);
		sort(nums, l, j - 1);
		sort(nums, j + 1, h);
	}

	private int partition(int[] nums, int l, int h) {
		int i = l;
		int j = h + 1;
		int v = nums[l];
		while (true) {
			while (nums[++i] <= v && i != h) ;
			while (nums[--j] >= v && j != l) ;
			if (i >= j) {
				break;
			}
			swap(nums, i, j);
		}
		swap(nums, l, j);
		return j;
	}

	private void swap(int[] nums, int l, int h) {
		int temp = nums[l];
		nums[l] = nums[h];
		nums[h] = temp;
	}

	public static void main(String[] args) {
		ArrayPairSum a = new ArrayPairSum();
		int[] nums = {1, 1};
		a.quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
