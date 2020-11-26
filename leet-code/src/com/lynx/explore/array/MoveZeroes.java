package com.lynx.explore.array;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/2 18:31
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/1426/
 */
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, j++);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] nums = {0, 1, 0, 3, 12};
		m.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}
