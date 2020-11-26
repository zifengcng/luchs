package com.lynx.explore.primary;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/29 18:06
 * 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int len = digits.length;

		int carry = 0;
		for (int i = len - 1; i >= 0; --i) {
			int s = digits[i] + carry;
			if (i == len - 1) {
				s++;
			}
			if (s >= 10) {
				digits[i] = s % 10;
				carry = 1;
			} else {
				digits[i] = s;
				carry = 0;
			}
		}
		if (digits[0] == 0) {
			int[] res = new int[len + 1];
			res[0] = 1;
			System.arraycopy(res, 1, digits, 0, len);
			return res;
		}
		return digits;
	}

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		int[] nums = {9};
		int[] ints = plusOne.plusOne(nums);
		System.out.println(Arrays.toString(ints));
	}
}
