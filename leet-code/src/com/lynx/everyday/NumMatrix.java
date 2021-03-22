package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/3/2
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * <p>
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
@MidCode
public class NumMatrix {

    // TODO 待优化：使用二维前缀和
    // f(i,j) 为矩阵 matrix 的以 (i,j)为右下角的子矩阵的元素之和
    // f(i,j)=f(i−1,j)+f(i,j−1)−f(i−1,j−1)+matrix[i][j]

    private int len;
    private int[][][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        this.len = m;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;

        sum = new int[m + 1][n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 横向
                sum[i + 1][j + 1][0] = sum[i + 1][j][0] + matrix[i][j];
                // 纵向
                sum[i + 1][j + 1][1] = sum[i][j + 1][1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (len == 0) {
            return 0;
        }
        boolean row = Math.abs(row1 - row2) >= Math.abs(col1 - col2);
        int res = 0;
        if (row) {
            for (int i = row1; i <= row2; i++) {
                res += sum[i + 1][col2 + 1][0] - sum[i + 1][col1][0];
            }
        } else {
            for (int i = col1; i <= col2; i++) {
                res += sum[row2 + 1][i + 1][1] - sum[row1][i + 1][1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NumMatrix n = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(n.sumRegion(2, 1, 4, 3));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
