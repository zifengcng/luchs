package com.lynx.explore.array2;

/**
 * @author wbc
 * @date 2020/7/16 16:37
 * 验证回文串:正读==反读
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * https://leetcode-cn.com/explore/orignial/card/all-about-array/232/two-pointers/965/
 */
public class IsPalindrome {

	public boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = chars.length - 1;
		while (i < j) {
			while (i < chars.length && !Character.isLetterOrDigit(chars[i])) {
				i++;
			}
			while (j > 0 && !Character.isLetterOrDigit(chars[j])) {
				j--;
			}
			if (i > j) {
				break;
			}
			if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		boolean palindrome = isPalindrome.isPalindrome("   ");
		System.out.println(palindrome);
	}
}
