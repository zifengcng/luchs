package com.lynx.explore.queue;

/**
 * @author wbc
 * @date 2020/7/10 17:15
 * 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * <p>
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/892/
 */
public class UpdateMatrix {

	public int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dist = new int[m][n];
		int maxV = Integer.MAX_VALUE / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = maxV;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i - 1 >= 0) {
					dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1);
				}
				if (j - 1 >= 0) {
					dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1);
				}

			}
		}

		for (int i = m-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				if (i + 1 < m) {
					dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1);
				}
				if (j + 1 < n) {
					dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1);
				}
			}
		}

		return dist;
	}

	private int min(int a, int b) {
		return Math.min(a, b);
	}


}
