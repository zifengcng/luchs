package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/3/8
 * <p>
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
@HardCode
public class MinCut {

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        Arrays.fill(dp, len - 1);

        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            minCutHelper(chars, dp, i, i, len);
            minCutHelper(chars, dp, i, i + 1, len);
        }

        return dp[len - 1];
    }

    private void minCutHelper(char[] chars, int[] dp, int i, int j, int len) {
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            dp[j] = Math.min(dp[j], (i == 0 ? -1 : dp[i - 1]) + 1);
            System.out.println("dp[" + j + "] = " + dp[j]);
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        MinCut m = new MinCut();
        System.out.println(m.minCut("abcbabbabcba"));
    }
}
