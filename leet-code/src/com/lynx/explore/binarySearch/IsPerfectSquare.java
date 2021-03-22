package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/21 15:44
 * 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 * https://leetcode-cn.com/explore/learn/card/binary-search/213/conclusion/851/
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long l = 2;
        long r = num / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long s = mid * mid;
            if (s == num) {
                return true;
            } else if (s < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare(9));
    }
}
