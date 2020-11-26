package com.lynx.explore.queue;

import java.util.Stack;

/**
 * @author wbc
 * @date 2020/7/10 11:21
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/890/
 */
public class DecodeString {

	public String decodeString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		Stack<String> stack = new Stack<>();

		int length = s.length();
		char[] chars = s.toCharArray();
		int index = 0;

		while (index < length) {
			if (isNum(chars[index])) {
				StringBuilder sb = new StringBuilder();
				sb.append(chars[index++]);
				while (index < length && isNum(chars[index])) {
					sb.append(chars[index++]);
				}
				stack.push(sb.toString());
			} else if (Character.isLetter(chars[index]) || chars[index] == '[') {
				StringBuilder sb = new StringBuilder();
				sb.append(chars[index++]);
				while (index < length && (Character.isLetter(chars[index]) || chars[index] == '[')) {
					sb.append(chars[index++]);
				}
				stack.push(sb.toString());
			} else {
				index++;
				// 去掉'['
				StringBuilder p1 = new StringBuilder(stack.pop());
				while (!p1.toString().startsWith("[")) {
					p1.insert(0, stack.pop());
				}
				p1 = new StringBuilder(p1.substring(1));
				int times = Integer.parseInt(stack.pop());
				StringBuilder sb = new StringBuilder();
				while (times-- > 0) {
					sb.append(p1);
				}
				stack.push(sb.toString());
			}
		}

		return String.join("", stack);
	}

	private boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		DecodeString d = new DecodeString();
		String s = d.decodeString("3[a2[c]]");
		System.out.println(s);
	}

}
