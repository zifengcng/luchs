package com.lynx.explore.find;

/**
 * @author wbc
 * @date 2020/7/13 15:02
 * 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/987/
 */
public class IsIsomorphic {

	public boolean isIsomorphic(String s, String t) {
		return canMap(s, t) && canMap(t, s);
	}

	private boolean canMap(String s, String t) {
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();

		int[] map = new int[128];

		for (int i = 0; i < s1.length; i++) {
			if (map[s1[i]] == 0) {
				map[s1[i]] = t1[i];
			} else {
				if (map[s1[i]] != t1[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsIsomorphic isI = new IsIsomorphic();
		boolean isomorphic = isI.isIsomorphic("aa", "ab");
		System.out.println(isomorphic);
	}
}
