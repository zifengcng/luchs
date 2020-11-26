package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 9:37
 * 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 * https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/841/
 */
public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		while (left < right) {
			if (left + 1 <= right && nums[left + 1] < nums[left]) {
				return left;
			}
			if (right - 1 >= left && nums[right - 1] < nums[right]) {
				return right;
			}
			left++;
			right--;
		}
		return left;
	}

	public int findPeakElement2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return search(nums, 0 , nums.length - 1);
	}

	private int search(int[] nums, int l, int h) {
		if (l == h) {
			return l;
		}
		int mid = l+(h-l)/2;
		if (nums[mid]>nums[mid+1]) {
			return search(nums, l, mid);
		}
		return search(nums, mid + 1, h);
	}

	public static void main(String[] args) {
		FindPeakElement findPeakElement = new FindPeakElement();
		int index = findPeakElement.findPeakElement(new int[]{1});
		System.out.println(index);
	}
}
