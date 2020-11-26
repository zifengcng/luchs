package com.lynx.explore.primary;

/**
 * @author wbc
 * @date 2020/7/30 10:52
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/
 */
public class ReverseInt {

	public int reverse(int x) {
		int res = 0;
		int a = Integer.MAX_VALUE / 10;
		int b = Integer.MIN_VALUE / 10;

		while (x != 0) {
			int pop = x % 10;
			if (res > a || (res == a && pop > 7)) {
				return 0;
			}
			if (res < b || (res == b && pop < -8)) {
				return 0;
			}
			x /= 10;
			res = res * 10 + pop;
		}
		return res;
	}

	public int reverse2(int x) {
		int res = 0;
		while (x != 0) {
			if (res * 10 / 10 != res) {
				return 0;
			}
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	}


	public static void main(String[] args) {
		//2147483647  -2147483648
		int a = 214748365;
		if (a * 10 / 10 == a) {
			System.out.println(a * 10 / 10);
		} else {
			System.out.println(a * 10 / 10);
			System.out.println(a * 10);
		}
	}
}
