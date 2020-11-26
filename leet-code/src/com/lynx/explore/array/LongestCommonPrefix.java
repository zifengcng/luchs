package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/29 14:09
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/1417/
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		String ls = strs[0];
		for (String str : strs) {
			while (!str.startsWith(ls)) {
				if (ls.length() == 1) {
					return "";
				}
				ls = ls.substring(0, ls.length() - 1);
			}
		}
		return ls;
	}
}
