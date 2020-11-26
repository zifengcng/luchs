package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/20 16:56
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/838/
 */
public class SearchSpin {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return target == nums[0] ? 0 : -1;
		}
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[left] <= nums[mid]) {
				// 左半边有序
				if (target >= nums[left] && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// 右半边有序
				if (target >= nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

		}
		return -1;
	}



	public static void main(String[] args) {
		SearchSpin searchSpin = new SearchSpin();
		int search = searchSpin.search(new int[]{3,1}, 1);
		System.out.println(search);
	}
}
