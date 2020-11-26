package com.lynx.random;

import com.lynx.common.annotition.HardCode;

/**
 * @Author cheng
 * @Date 2020/11/6
 * LCP 25. 古董键盘
 * 小扣在秋日市集购买了一个古董键盘。由于古董键盘年久失修，键盘上只有 26 个字母 a~z 可以按下，且每个字母最多仅能被按 k 次。
 * <p>
 * 小扣随机按了 n 次按键，请返回小扣总共有可能按出多少种内容。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 1
 * <p>
 * 输出：26
 * <p>
 * 解释：由于只能按一次按键，所有可能的字符串为 "a", "b", ... "z"
 * <p>
 * 示例 2：
 * <p>
 * 输入：k = 1, n = 2
 * <p>
 * 输出：650
 * <p>
 * 解释：由于只能按两次按键，且每个键最多只能按一次，所有可能的字符串（按字典序排序）为 "ab", "ac", ... "zy"
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 5
 * 1 <= n <= 26*k
 * https://leetcode-cn.com/problems/Uh984O/
 */
@HardCode
public class Keyboard {

    public int keyboard(int k, int n) {
        long res = 1;
        long mod = (long) (10e9 + 7);
        int t = 26;
        for (int i = 0; i < n; i++) {
            if (k-- <= 0 && t != 1) {
                t--;
            }
            res *= t;
        }
        res %= mod;
        return res > Integer.MAX_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        Keyboard k = new Keyboard();
        // 26
        System.out.println(k.keyboard(1, 1));
        // 650
        System.out.println(k.keyboard(1, 2));
        // 26 * 25 * 24 = 15600
        System.out.println(k.keyboard(1, 3));
        System.out.println(26 * 25 * 24);

        System.out.println(k.keyboard(5, 26 * 5));

        System.out.println(Integer.MAX_VALUE);

        System.out.println((long) (10e9 + 7));

        System.out.println(k.keyboard(5, 50));
    }
}
