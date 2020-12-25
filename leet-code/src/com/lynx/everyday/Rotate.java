package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/12/19
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * https://leetcode-cn.com/problems/rotate-image/
 */
@MidCode
public class Rotate {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1) {
            return;
        }
        int n = matrix.length;
        // 1横向翻转
        int half = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < half; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = matrix[i][j] ^ matrix[i][n - 1 - j];
                matrix[i][j] = matrix[i][j] ^ matrix[i][n - 1 - j];
            }
        }
        // 2以左下对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = matrix[i][j] ^ matrix[n - 1 - j][n - 1 - i];
                matrix[i][j] = matrix[i][j] ^ matrix[n - 1 - j][n - 1 - i];
            }
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
