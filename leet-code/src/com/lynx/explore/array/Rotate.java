package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/28 18:54
 *
 * 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/1414/
 */
public class Rotate {

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int length = matrix.length;
		int half = (length + 1) / 2;
		for (int i = 0; i < length; i++) {
			for (int j = i+1; j < length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int j = 0; j < half; j++) {
			for (int i = 0; i < length; i++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][length-1-j];
				matrix[i][length-1-j] = temp;
			}
		}
	}

}
