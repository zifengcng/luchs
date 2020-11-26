package com.lynx.explore.prefixTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/28 18:19
 * 数组中两个数的最大异或值
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 * <p>
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * <p>
 * 你能在O(n)的时间解决这个问题吗？
 * <p>
 * 示例:
 * <p>
 * 输入: [3, 10, 5, 25, 2, 8]
 * <p>
 * 输出: 28
 * <p>
 * 解释: 最大的结果是 5 ^ 25 = 28.
 * https://leetcode-cn.com/explore/learn/card/trie/168/practical-application-ii/651/
 */
public class FindMaximumXOR {

	public int findMaximumXOR(int[] nums) {
		int max = nums[0];
		for (int num : nums) {
			max = Integer.max(max, num);
		}
		int l = Integer.toBinaryString(max).length();
		int bitmask = 1 << l;
		int index = 0;
		String[] strs = new String[nums.length];
		for (int num : nums) {
			strs[index++] = Integer.toBinaryString(num | bitmask).substring(1);
		}

		TrieNode trieNode = new TrieNode();
		int maxXor = 0;
		for (String num : strs) {
			TrieNode node = trieNode;
			TrieNode xNode = trieNode;
			int cur = 0;
			for (Character c : num.toCharArray()) {
				if (node.children.containsKey(c)) {
					node = node.children.get(c);
				} else {
					TrieNode n = new TrieNode();
					node.children.put(c, n);
					node = n;
				}

				Character toggledBit = c == '1' ? '0' : '1';
				if (xNode.children.containsKey(toggledBit)) {
					cur = (cur << 1) | 1;
					xNode = xNode.children.get(toggledBit);
				} else {
					cur = cur << 1;
					xNode = xNode.children.get(c);
				}
			}
			maxXor = Integer.max(maxXor, cur);
		}
		return maxXor;
	}

	class TrieNode {
		private Map<Character, TrieNode> children;

		public TrieNode() {
			children = new HashMap<>();
		}
	}
}
