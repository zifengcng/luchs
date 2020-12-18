package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/12/9
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * https://leetcode-cn.com/problems/unique-paths/
 */
@MidCode
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
        Arrays.fill(matrix[0], 1);
        for (int i = 0; i < n; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        //示例 1:
        //
        //输入: m = 3, n = 2
        //输出: 3
        //解释:
        //从左上角开始，总共有 3 条路径可以到达右下角。
        //1. 向右 -> 向右 -> 向下
        //2. 向右 -> 向下 -> 向右
        //3. 向下 -> 向右 -> 向右
        int m = 3;
        int n = 2;
        System.out.println(u.uniquePaths(m, n));

        //示例 2:
        //
        //输入: m = 7, n = 3
        //输出: 28
        m = 7;
        n = 3;
        System.out.println(u.uniquePaths(m, n));


    }
}
