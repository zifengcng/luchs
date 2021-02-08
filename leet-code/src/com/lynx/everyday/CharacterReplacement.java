package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/2/2
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过 104。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 */
@MidCode
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxn = 0;
        int[] num = new int[26];

        while (right < len) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }

    public static void main(String[] args) {
        CharacterReplacement c = new CharacterReplacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(c.characterReplacement(s, k));

        s = "AABABBA";
        k = 1;
        System.out.println(c.characterReplacement(s, k));


        s = "ABBB";
        k = 2;
        System.out.println(c.characterReplacement(s, k));


    }
}
