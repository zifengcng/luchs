package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

/**
 * @Author cheng
 * @Date 2021/9/27
 * <p>
 * 639. 解码方法 II
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 * <p>
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 * <p>
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 * 示例 2：
 * <p>
 * 输入：s = "1*"
 * 输出：18
 * 解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
 * 每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
 * 因此，"1*" 共有 9 * 2 = 18 种解码方法。
 * 示例 3：
 * <p>
 * 输入：s = "2*"
 * 输出：15
 * 解释：这一条编码消息可以表示 "21"、"22"、"23"、"24"、"25"、"26"、"27"、"28" 或 "29" 中的任意一条。
 * "21"、"22"、"23"、"24"、"25" 和 "26" 由 2 种解码方法，但 "27"、"28" 和 "29" 仅有 1 种解码方法。
 * 因此，"2*" 共有 (6 * 2) + (3 * 1) = 12 + 3 = 15 种解码方法。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 是 0 - 9 中的一位数字或字符 '*'
 * https://leetcode-cn.com/problems/decode-ways-ii/
 */
@HardCode
public class NumDecodings2 {

    // 动态规划：
    // 集合为s[]
    // 设f(i) 为字符串s的前i个字符s[1..i]的解码方法数

    // 初始化：f(0) = 1,空字符串有一种解码方法

    // 状态转移时仅考虑最后一次解码所使用的字符，分两种情况：
    // 1.仅使用第i个字符是s[i]
    // s[i]为*时，可以选择数字1-9，则f(i) = 9*f(i-1)
    // s[i]为0时，f(i) = 0
    // 其他，f(i) = f(i-1)

    // 2.使用第i-1和第i两个字符是s[i-1]，s[i]
    // s[i-1]和s[i]都为*时，有11-19,21-26共15种选择，f(i) = 15 * f(i-2);
    // s[i-1]为*时：
    //  f(i) = 2*f(i-2), s[i]属于[1,6]
    //  f(i) = f(i-2), s[i]属于[7,9]
    // s[i]为*时：
    //  f(i) = 9*f(i-2), s[i-1]=1
    //  f(i) = 6*f(i-2), s[i-1]=2
    //  f(i) = 0, 其他

    // s[i-1]和s[i]都不为*时：
    // 只有s[i-1]不等于0，且s[i-1]*10+s[i]<=26时，才能被解码, f(i) = f(i-2)
    // f(i) = 0, 其他

    // 综上，f(i) = a*f(i-1) + b*f(i-2)

    public int numDecodings(String s) {
        final int MOD = 1000000007;

        int len = s.length();
        long[] dp = new long[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            int a = checkOneDigit(s.charAt(i - 1));
            dp[i] = (a * dp[i - 1]) % MOD;
            if (i > 1) {
                int b = checkTwoDigit(s.charAt(i - 2), s.charAt(i - 1));
                dp[i] = (dp[i] + b * dp[i - 2]) % MOD;
            }
        }

        return (int) (dp[len]);
    }

    private int checkTwoDigit(char a, char b) {
        if (a == '*' && b == '*') {
            return 15;
        }
        if (a == '*') {
            return b - '0' > 6 ? 1 : 2;
        }
        if (b == '*') {
            if (a == '1') {
                return 9;
            }
            if (a == '2') {
                return 6;
            }
            return 0;
        }
        if (a != '0' && (a - '0') * 10 + (b - '0') <= 26) {
            return 1;
        }
        return 0;
    }

    private int checkOneDigit(char c) {
        if (c == '*') {
            return 9;
        }
        if (c == '0') {
            return 0;
        }
        return 1;
    }

    public int numDecodings2(String s) {
        final int MOD = 1000000007;

        int len = s.length();

        // f(i-2), f(i-1), f(i)
        long x = 0;
        long y = 1;
        long z = 0;

        for (int i = 1; i <= len; i++) {
            int a = checkOneDigit(s.charAt(i - 1));
            z = (a * y) % MOD;
            if (i > 1) {
                int b = checkTwoDigit(s.charAt(i - 2), s.charAt(i - 1));
                z = (z + b * x) % MOD;
            }
            x = y;
            y = z;
        }

        return (int) z;
    }


    public static void main(String[] args) {
        NumDecodings2 n = new NumDecodings2();

        // 示例 1：
        //
        //输入：s = "*"
        //输出：9
        //解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
        //可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
        //因此，"*" 总共有 9 种解码方法。
        String s = "*";
        assert (n.numDecodings(s) == 9);

        // 示例 2：
        //
        //输入：s = "1*"
        //输出：18
        //解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
        //每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
        //因此，"1*" 共有 9 * 2 = 18 种解码方法。
        s = "1*";
        assert (n.numDecodings(s) == 18);

        // 示例 3：
        //
        //输入：s = "2*"
        //输出：15
        //解释：这一条编码消息可以表示 "21"、"22"、"23"、"24"、"25"、"26"、"27"、"28" 或 "29" 中的任意一条。
        //"21"、"22"、"23"、"24"、"25" 和 "26" 由 2 种解码方法，但 "27"、"28" 和 "29" 仅有 1 种解码方法。
        //因此，"2*" 共有 (6 * 2) + (3 * 1) = 12 + 3 = 15 种解码方法。
        s = "2*";
        assert (n.numDecodings(s) == 15);

    }
}