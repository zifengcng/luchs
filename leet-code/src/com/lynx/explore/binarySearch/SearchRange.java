package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 10:24
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * https://leetcode-cn.com/explore/learn/card/binary-search/211/template-iii/844/
 */
public class SearchRange {

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		int[] res = new int[]{-1, -1};

		int leftIndex = extremeInsertionIndex(nums, target, true);
		if (leftIndex == nums.length || nums[leftIndex] != target) {
			return res;
		}

		res[0] = leftIndex;
		res[1] = extremeInsertionIndex(nums, target, false) - 1;
		return res;
	}

	private int extremeInsertionIndex(int[] nums, int target, boolean left) {
		int l = 0;
		int r = nums.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if ((nums[mid] > target) || (nums[mid] == target && left)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}
