package com.lynx.explore.binarySearch;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/21 19:09
 * 找出第 k 小的距离对
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 提示:
 * <p>
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * https://leetcode-cn.com/explore/learn/card/binary-search/215/more-practices-ii/860/
 */
public class SmallestDistancePair {

	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);

		int l = 0;
		int r = nums[nums.length - 1] - nums[0];

		while (l < r) {
			int mid = (l + r) / 2;
			int count = 0;
			int left = 0;
			for (int i = 0; i < nums.length; i++) {
				while (nums[i] - nums[left] > mid) {
					left++;
				}
				count += (i - left);
			}

			if (count >= k) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return l;
	}

	public static void main(String[] args) {
		SmallestDistancePair pa = new SmallestDistancePair();
		System.out.println(pa.smallestDistancePair(new int[]{1,3,1}, 2));
	}
}
