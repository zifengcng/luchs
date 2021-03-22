package com.lynx.explore.binarySearch;

/**
 * @author wbc
 * @date 2020/7/20 16:32
 * x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/836/
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long left = 1;
        long right = x / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * mid;
            if (sum == x) {
                return (int) mid;
            } else if (sum < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
}
