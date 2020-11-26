package com.lynx.explore.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wbc
 * @date 2020/7/13 19:10
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/238/lookup-table-related-sum-questions/995/
 */
public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i > 1 && nums[i] == nums[i - 1]) {
				continue;
			}
			List<List<Integer>> list = threeSum(nums, i, target - nums[i]);
			if (!list.isEmpty()) {
				for (List<Integer> items : list) {
					items.add(nums[i]);
				}
				res.addAll(list);
			}
		}

		return res.stream().distinct().collect(Collectors.toList());
	}

	private List<List<Integer>> threeSum(int[] nums, int index, int target) {
		List<List<Integer>> res = new ArrayList<>();

		for (int i = index + 1; i < nums.length; i++) {
			List<List<Integer>> list = twoSum(nums, i, target - nums[i]);
			if (!list.isEmpty()) {
				res.addAll(list);
			}
		}
		return res;
	}

	private List<List<Integer>> twoSum(int[] nums, int index, int target) {
		List<List<Integer>> res = new ArrayList<>();

		int l = index + 1;
		int h = nums.length - 1;
		while (l < h) {
			int sum = nums[l] + nums[h];
			if (sum < target) {
				l++;
			} else if (sum > target) {
				h--;
			} else {
				res.add(new ArrayList<>(Arrays.asList(nums[index], nums[l], nums[h])));
				l++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		List<List<Integer>> lists = fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
		System.out.println(lists);
	}
}
