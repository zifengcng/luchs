package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 10:04
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 你可以假设数组中不存在重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/842/
 */
public class FindMin {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int l = 0;
		int r = nums.length - 1;
		if (nums[l] <= nums[r]) {
			return nums[l];
		}

		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > nums[mid + 1]) {
				return nums[mid+1];
			} else {
				if (nums[mid] > nums[l]) {
					l = mid;
				} else {
					r = mid;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindMin findMin = new FindMin();
		int min = findMin.findMin(new int[]{3,4,1,2});
		System.out.println(min);
	}
}
