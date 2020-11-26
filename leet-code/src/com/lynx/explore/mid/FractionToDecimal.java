package com.lynx.explore.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/8/24
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 * <p>
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 * <p>
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwm8ne/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            res.append("-");
        }
        long a = numerator;
        long b = denominator;
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        long integer = a / b;
        res.append(integer);
        a %= b;

        /*
         * 1/17
         * 10/17 0...10
         * 100/17 5...15
         * 商，余数，index
         */
        Map<String, Integer> exists = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        int i = 0;
        while (true) {
            if (a == 0) {
                if (temp.length() > 0) {
                    res.append(".").append(temp);
                }
                return res.toString();
            }
            a *= 10;
            long num = a / b;
            a %= b;
            String key = num + "#" + a;
            if (exists.containsKey(key)) {
                int index = exists.get(key);
                res.append(".").append(temp.substring(0, index)).append("(").append(temp.substring(index)).append(")");
                return res.toString();
            }
            exists.put(key, i++);
            temp.append(num);
        }
    }

    public static void main(String[] args) {
        FractionToDecimal f = new FractionToDecimal();
        System.out.println(f.fractionToDecimal(-7, 12));
    }
}
