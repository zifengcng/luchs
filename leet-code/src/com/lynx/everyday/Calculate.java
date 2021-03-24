package com.lynx.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author cheng
 * @Date 2021/3/10
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class Calculate {

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                continue;
            }

        }
        // TODO
        return 0;
    }
}
