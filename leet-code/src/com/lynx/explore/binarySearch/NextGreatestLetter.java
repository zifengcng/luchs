package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 16:10
 * 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * https://leetcode-cn.com/explore/learn/card/binary-search/213/conclusion/852/
 */
public class NextGreatestLetter {

	public char nextGreatestLetter(char[] letters, char target) {
		int l = 0;
		int r = letters.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (letters[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}
		return letters[l % letters.length];
	}

	public static void main(String[] args) {
		NextGreatestLetter next = new NextGreatestLetter();
		System.out.println(next.nextGreatestLetter(new char[]{'a', 'b'}, 'k'));
	}
}
