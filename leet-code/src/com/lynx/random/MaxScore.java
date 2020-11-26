package com.lynx.random;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2020/10/21
 * <p>
 * 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即 左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "011101"
 * 输出：5
 * 解释：
 * 将字符串 s 划分为两个非空子字符串的可行方案有：
 * 左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5
 * 左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4
 * 左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3
 * 左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2
 * 左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：5
 * 解释：当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 500
 * 字符串 s 仅由字符 '0' 和 '1' 组成。
 * <p>
 * https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/
 */
@EasyCode
public class MaxScore {

    public int maxScore(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = chars[0] == '0' ? 1 : 0;
        right[len - 1] = chars[len - 1] == '1' ? 1 : 0;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1];
            if (chars[i] == '0') {
                left[i]++;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (chars[i] == '1') {
                right[i]++;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, left[i] + right[i + 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxScore m = new MaxScore();
        System.out.println(m.maxScore("1111"));
    }
}
