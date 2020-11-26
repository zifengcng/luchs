package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/7/2 16:50
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/1423/
 */
public class ReverseWordsThree {

	public String reverseWords(String s) {
		if (s.trim().isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		int l = 0;
		int r = 0;
		int length = s.length();
		while (r < length) {
			while (++r < length && s.charAt(r) != ' ' );
			String s1 = s.substring(l, r);
			String s2 = new StringBuilder(s1).reverse().toString();
			sb.append(s2).append(" ");
			l = r + 1;
		}
		return sb.substring(0, sb.length() - 1);
	}

	public static void main(String[] args) {
		ReverseWordsThree t = new ReverseWordsThree();
		System.out.println(t.reverseWords("Let's take LeetCode contest"));
	}
}
