package com.lynx.explore.primary;

/**
 * @author wbc
 * @date 2020/7/30 9:45
 * 旋转图像
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
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
 */
public class RotateMatrix {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n+1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int a = i;
				int b = j;
				int prev = matrix[a][b];
				for (int k = 0; k < 4; k++) {
					int t = n - 1 - a;
					int temp = matrix[b][t];
					matrix[b][t] = prev;
					prev = temp;
					a = b;
					b = t;
				}
			}
		}
	}

	public static void main(String[] args) {
		RotateMatrix rotateMatrix = new RotateMatrix();
		int[][] maxtrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateMatrix.rotate(maxtrix);

		int n = maxtrix.length;
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(maxtrix[i][j]).append(",");
			}
			System.out.println(sb.toString());
		}

	}
}
