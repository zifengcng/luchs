package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2020/12/18
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * https://leetcode-cn.com/problems/find-the-difference/
 */
@EasyCode
public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int[] letterCount = new int[26];
        for (char c : t.toCharArray()) {
            letterCount[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            letterCount[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return '-';
    }

    public char findTheDifference2(String s, String t) {
        int len = s.length();
        char c = t.charAt(len);
        for (int i = 0; i < len; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

}
