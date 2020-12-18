package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/12/7
 * 861. 翻转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/
 */
@MidCode
public class MatrixScore {

    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = (A[i][j] == 1) ? 0 : 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int countZeros = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 0) {
                    countZeros++;
                }
            }

            if (countZeros * 2 > m) {
                for (int j = 0; j < m; j++) {
                    A[j][i] = (A[j][i] == 1) ? 0 : 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    res += Math.pow(2, n - j - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MatrixScore m = new MatrixScore();
        int[][] nums = {{0,1,1}, {1,1,1}, {0,1,0}};
        System.out.println(m.matrixScore(nums));
    }

}
