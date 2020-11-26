package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 18:53
 */
public class FindMedianSortedArrays2 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total % 2 == 1) {
			return getKthElement(nums1, nums2, total / 2 + 1);
		} else {
			return (getKthElement(nums1, nums2, total / 2) + getKthElement(nums1, nums2, total / 2 + 1)) / 2.0;
		}
	}

	private int getKthElement(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int index1 = 0;
		int index2 = 0;

		while (true) {
			if (index1 == len1) {
				return nums2[index2 + k - 1];
			}
			if (index2 == len2) {
				return nums1[index1 + k - 1];
			}
			if (k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}

			int half = k / 2;
			int newIndex1 = Math.min(half + index1, len1) - 1;
			int newIndex2 = Math.min(half + index2, len2) - 1;

			if (nums1[newIndex1] <= nums2[newIndex2]) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			} else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}

		}
	}
}
