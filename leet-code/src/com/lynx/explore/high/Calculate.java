package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/8/26
 * 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwsg7t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Calculate {

    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = s.replace(" ", "");

        int res = 0;

        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        operators.add('a');

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                operators.add(c);
                nums.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (sb.length() > 0) {
            nums.add(Integer.parseInt(sb.toString()));
        }
        if (nums.isEmpty()) {
            return 0;
        }
        res += nums.get(0);

        int size = operators.size();
        int i = 1;
        while (i < size) {
            Character cur = operators.get(i);
            if (cur == '+' || cur == '-') {
                int t = i + 1;
                int next = nums.get(i);
                while (t < size) {
                    Character c = operators.get(t);
                    if (c.equals('*')) {
                        next *= nums.get(t);
                    } else if (c.equals('/')) {
                        next /= nums.get(t);
                    } else {
                        t--;
                        break;
                    }
                    t++;
                }
                if (cur == '+') {
                    res += next;
                } else {
                    res -= next;
                }
                i = t;
            } else {
                if (cur == '*') {
                    res *= nums.get(i);
                } else {
                    res /= nums.get(i);
                }
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("2"));
    }
}
