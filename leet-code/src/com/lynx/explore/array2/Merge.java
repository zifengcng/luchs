package com.lynx.explore.array2;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/16 11:56
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/231/apply-basic-algorithm-thinking/961/
 */
public class Merge {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = 0;
		int j = 0;
		int index = 0;

		while (index <= m + n - 1) {
			if (i >= m) {
				nums1[index++] = nums2[j++];
			} else if (j >= n) {
				nums1[index++] = nums1[i++];
			} else if (nums1[i] <= nums2[j]) {
				i++;
				index++;
			} else {
				int t = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = t;
				i++;
				index++;

				int k = j;
				while (k + 1 < n && nums2[k] > nums2[k + 1]) {
					swap(nums2, k, k + 1);
					k++;
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
		Merge merge = new Merge();
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		merge.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}
