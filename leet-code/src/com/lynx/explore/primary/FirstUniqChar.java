package com.lynx.explore.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/30 14:04
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 */
public class FirstUniqChar {

	public int firstUniqChar(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : chars) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (map.get(c) == 1) {
				return i;
			}
		}

		return -1;
	}


}
