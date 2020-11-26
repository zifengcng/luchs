package com.lynx.random;

import com.lynx.common.annotition.HardCode;

/**
 * @Author cheng
 * @Date 2020/11/3
 * <p>
 * 1643. 第 K 条最小指令 显示英文描述
 * 通过的用户数341
 * 尝试过的用户数794
 * 用户总通过次数357
 * 用户总提交次数1386
 * 题目难度Hard
 * Bob 站在单元格 (0, 0) ，想要前往目的地 destination ：(row, column) 。他只能向 右 或向 下 走。你可以为 Bob 提供导航 指令 来帮助他到达目的地 destination 。
 * <p>
 * 指令 用字符串表示，其中每个字符：
 * <p>
 * 'H' ，意味着水平向右移动
 * 'V' ，意味着竖直向下移动
 * 能够为 Bob 导航到目的地 destination 的指令可以有多种，例如，如果目的地 destination 是 (2, 3)，"HHHVV" 和 "HVHVH" 都是有效 指令 。
 * <p>
 * 然而，Bob 很挑剔。因为他的幸运数字是 k，他想要遵循 按字典序排列后的第 k 条最小指令 的导航前往目的地 destination 。k  的编号 从 1 开始 。
 * <p>
 * 给你一个整数数组 destination 和一个整数 k ，请你返回可以为 Bob 提供前往目的地 destination 导航的 按字典序排列后的第 k 条最小指令 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：destination = [2,3], k = 1
 * 输出："HHHVV"
 * 解释：能前往 (2, 3) 的所有导航指令 按字典序排列后 如下所示：
 * ["HHHVV", "HHVHV", "HHVVH", "HVHHV", "HVHVH", "HVVHH", "VHHHV", "VHHVH", "VHVHH", "VVHHH"].
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：destination = [2,3], k = 2
 * 输出："HHVHV"
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：destination = [2,3], k = 3
 * 输出："HHVVH"
 * <p>
 * <p>
 * 提示：
 * <p>
 * destination.length == 2
 * 1 <= row, column <= 15
 * 1 <= k <= nCr(row + column, row)，其中 nCr(a, b) 表示组合数，即从 a 个物品中选 b 个物品的不同方案数。
 * <p>
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/kth-smallest-instructions/
 */
@HardCode
public class KthSmallestPath {

    public String kthSmallestPath(int[] destination, int k) {
        int row = destination[0];
        int column = destination[1];

        int h = column;
        int v = row;

        int[][] dp = new int[h + v][h];
        dp[0][0] = 1;

        for (int i = 1; i < h + v; i++) {
            dp[i][0] = 1;

            for (int j = 1; j <= i && j < h; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (h > 0 && v > 0) {
            int c = dp[h + v - 1][h - 1];
            if (k > c) {
                v--;
                k -= c;
                sb.append("V");
            } else {
                h--;
                sb.append("H");
            }
        }

        if (h == 0) {
            for (int i = 0; i < v; i++) {
                sb.append("V");
            }
        } else {
            for (int i = 0; i < h; i++) {
                sb.append("H");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        KthSmallestPath k = new KthSmallestPath();
        System.out.println(k.kthSmallestPath(new int[]{2, 3}, 1));
    }
}
