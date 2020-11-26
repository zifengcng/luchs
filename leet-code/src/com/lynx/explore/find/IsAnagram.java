package com.lynx.explore.find;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wbc
 * @date 2020/7/13 14:41
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/985/
 */
public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		if (t.length() != s.length()) {
			return false;
		}

		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1) {
			map.merge(c, 1, Integer::sum);
		}
		for (char c : t1) {
			Integer num = map.get(c);
			if (num != null) {
				map.put(c, num - 1);
			} else {
				return false;
			}
		}

		return map.values().stream().noneMatch(v -> v > 0);
	}
}
