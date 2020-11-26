package com.lynx.explore.binarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/21 10:49
 * 找到 K 个最接近的元素
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5], k=4, x=-1
 * 输出: [1,2,3,4]
 * <p>
 * <p>
 * 说明:
 * <p>
 * k 的值为正数，且总是小于给定排序数组的长度。
 * 数组不为空，且长度不超过 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 * https://leetcode-cn.com/explore/learn/card/binary-search/211/template-iii/845/
 */
public class FindClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();

		int mid = getMid(arr, x);
		int left = mid - 1;
		int right = mid;
		for (int i = 0; i < k; i++) {
			if (left >= 0 && right <= arr.length - 1) {
				if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
					res.add(arr[left--]);
				} else {
					res.add(arr[right++]);
				}
			} else if (left < 0) {
				res.add(arr[right++]);
			} else {
				res.add(arr[left--]);
			}
		}
		res.sort(Comparator.comparing(Integer::intValue));
		return res;
	}

	private int getMid(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		FindClosestElements findClosestElements = new FindClosestElements();
		List<Integer> elements = findClosestElements.findClosestElements(new int[]{1, 2, 3, 4, 5, 7, 9}, 3, 3);
		System.out.println(elements);
	}
}
