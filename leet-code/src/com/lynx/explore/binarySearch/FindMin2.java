package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 16:27
 * 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * https://leetcode-cn.com/explore/learn/card/binary-search/214/more-practices/854/
 */
public class FindMin2 {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums[0] < nums[nums.length - 1]) {
			return nums[0];
		}
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[r]) {
				l = mid + 1;
			} else if (nums[mid] < nums[r]) {
				r = mid;
			} else {
				r--;
			}
		}
		return nums[r];
	}

	public static void main(String[] args) {
		FindMin2 findMin2 = new FindMin2();
		System.out.println(findMin2.findMin(new int[]{10, 1, 10, 10, 10}));
	}
}
