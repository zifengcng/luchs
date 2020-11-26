package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/7/2 14:54
 * 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/788/
 */
public class FindMaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {
		int maxLen = 0;
		int lp = 0;
		int rp = nums.length - 1;
		while (true) {
			int leftLen = 0;
			while (nums[lp++] == 1) {
				leftLen++;
				if (lp >= nums.length) {
					break;
				}
			}
			int rLen = 0;
			while (nums[rp--] == 1) {
				rLen++;
				if (rp < 0) {
					break;
				}
			}
			int max = Math.max(leftLen, rLen);
			if (maxLen < max) {
				maxLen = max;
			}
			if (lp >= rp) {
				break;
			}
		}
		return maxLen;
	}
}
