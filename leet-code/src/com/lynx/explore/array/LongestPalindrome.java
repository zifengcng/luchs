package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/29 14:20
 * <p>
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/1418/
 */
public class LongestPalindrome {

	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		String maxStr = s.substring(0, 1);

		for (int i = 0; i < s.length() - 1; i++) {
			String oddStr = centerSpread(s, i, i);
			String evenStr = centerSpread(s, i, i + 1);
			String max = oddStr.length() > evenStr.length() ? oddStr : evenStr;
			if (max.length() > maxStr.length()) {
				maxStr = max;
			}
		}

		return maxStr;
	}

	private String centerSpread(String s, int left, int right) {
		int length = s.length();
		int i = left;
		int j = right;
		while (i >= 0 && j < length) {
			if (s.charAt(i) == s.charAt(j)) {
				i--;
				j++;
			} else {
				break;
			}
		}
		return s.substring(i+1, j);
	}


	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		String str = l.longestPalindrome("ccc");
		System.out.println(str);
	}
}
