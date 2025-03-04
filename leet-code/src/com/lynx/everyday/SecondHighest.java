package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @author wubaocheng1
 * @date 2022/12/3 17:50
 *
 * 1796. 字符串中第二大的数字
 * 简单
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 *
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 */
@EasyCode
public class SecondHighest {

    public int secondHighest(String s) {
        int length = s.length();
        if (length <= 1) {
            return -1;
        }
        char[] chars = s.toCharArray();
        int max = -1;
        int secondHighest = -1;

        for (int i = 0; i < length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                continue;
            }
            int num = chars[i] - '0';
            if (num > max) {
                secondHighest = max;
                max = num;
            } else if (num != max && num > secondHighest) {
                secondHighest = num;
            }
        }
        return secondHighest;
    }

}
