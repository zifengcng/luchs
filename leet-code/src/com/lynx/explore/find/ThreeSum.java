package com.lynx.explore.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wbc
 * @date 2020/7/13 17:57
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/238/lookup-table-related-sum-questions/993/
 */
public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i > 1 && nums[i] == nums[i - 1]) {
				continue;
			}
			List<List<Integer>> list = twoSum(nums, i);
			if (!list.isEmpty()) {
				res.addAll(list);
			}
		}

		return res.stream().distinct().collect(Collectors.toList());
	}

	private List<List<Integer>> twoSum(int[] nums, int i) {
		List<List<Integer>> res = new ArrayList<>();

		int target = 0 - nums[i];
		int l = i + 1;
		int h = nums.length - 1;
		while (l < h) {
			int sum = nums[l] + nums[h];
			if (sum < target) {
				l++;
			} else if (sum > target) {
				h--;
			} else {
				res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[h])));
				l++;
			}
		}

//		Set<Integer> visited = new HashSet<>();
//		Map<Integer, Integer> diff = new HashMap<>();
//		for (int j = i + 1; j < nums.length; j++) {
//			if (visited.contains(j)) {
//				continue;
//			}
//			Integer index = diff.get(nums[j]);
//			if (index != null) {
//				if (visited.contains(index)) {
//					continue;
//				}
//				visited.add(j);
//				visited.add(index);
//				res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[index])));
//			}
//			diff.put(target - nums[j], j);
//		}

		return res;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		List<List<Integer>> lists = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println(lists);
	}
}
