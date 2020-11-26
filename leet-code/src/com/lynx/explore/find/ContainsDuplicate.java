package com.lynx.explore.find;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/13 11:49
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/236/learn-to-use-set/981/
 */
public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> visited = new HashSet<>();

		for (int num : nums) {
			if (visited.contains(num)) {
				return true;
			}
			visited.add(num);
		}
		return false;
	}
}
