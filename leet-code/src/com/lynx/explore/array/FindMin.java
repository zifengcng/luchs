package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/7/2 17:07
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
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/1424/
 */
public class FindMin {

	public int findMin(int[] nums) {
		int min = Math.min(nums[0], nums[nums.length-1]);
		for (int i = 1; i < nums.length - 1; i++) {
			if (min < nums[i]) {
				min = nums[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] nums = {3, 4, 5, 1, 2};
		int min = new FindMin().findMin(nums);
		System.out.println(min);
	}
}
