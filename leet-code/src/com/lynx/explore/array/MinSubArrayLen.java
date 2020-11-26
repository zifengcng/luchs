package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/7/2 15:19
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/789/
 */
public class MinSubArrayLen {

	public int minSubArrayLen(int s, int[] nums) {

		int l = 0;
		int r = 0;
		int sum = 0;
		int length = nums.length;
		int minL = length + 1;
		while (l < length) {
			if (r < length && sum < s) {
				sum += nums[r++];
			} else {
				sum -= nums[l++];
			}
			if (sum >= s) {
				if (minL > r - l) {
					minL = r - l;
				}
			}
		}
		if (minL == length + 1) {
			return 0;
		}
		return minL;
	}


	public static void main(String[] args) {
		MinSubArrayLen m = new MinSubArrayLen();
		int i = m.minSubArrayLen(80, new int[]{10, 5, 13, 4, 8, 4, 5, 11, 14, 9, 16, 10, 20, 8});
		System.out.println(i);
	}
}
