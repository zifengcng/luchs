package com.lynx.explore.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/13 17:25
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/238/lookup-table-related-sum-questions/991/
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> diff = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer index = diff.get(nums[i]);
			if (index != null && index != i) {
				return new int[]{i, index};
			}
			diff.put(target - nums[i], i);
		}
		return new int[2];
	}

	public static void main(String[] args) {
		TwoSum t = new TwoSum();
		int[] ints = t.twoSum(new int[]{3, 2, 4}, 6);
		System.out.println(Arrays.toString(ints));
	}
}
