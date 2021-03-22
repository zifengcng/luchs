package com.lynx.explore.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/20 14:45
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * https://leetcode-cn.com/explore/learn/card/hash-table/207/conclusion/826/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        int max = Integer.MIN_VALUE;

        while (fast < chars.length) {
            char c = chars[fast];
            if (!set.contains(c)) {
                set.add(c);
                fast++;
            } else {
                max = Integer.max(max, fast - slow);
                while (chars[slow] != c) {
                    set.remove(chars[slow]);
                    slow++;
                }
                slow++;
                fast++;
            }
        }
        max = Integer.max(max, fast - slow);
        return max;
    }
}
