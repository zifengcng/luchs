package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/1
 * 矩阵中的最长递增路径
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xde3ji/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int res = 0;

        Integer[][] maxLen = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, m, n, i, j, maxLen);
                if (maxLen[i][j] != null) {
                    res = Math.max(res, maxLen[i][j]);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, int m, int n, int i, int j, Integer[][] maxLen) {
        if (i < 0 || i >= m || j < 0 || j >= n || maxLen[i][j] != null) {
            return;
        }

        int res = 0;
        int s = matrix[i][j];
        if (i - 1 >= 0 && matrix[i - 1][j] > s) {
            dfs(matrix, m, n, i - 1, j, maxLen);
            res = Math.max(res, maxLen[i - 1][j]);
        }
        if (i + 1 < m && matrix[i + 1][j] > s) {
            dfs(matrix, m, n, i + 1, j, maxLen);
            res = Math.max(res, maxLen[i + 1][j]);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > s) {
            dfs(matrix, m, n, i, j - 1, maxLen);
            res = Math.max(res, maxLen[i][j - 1]);
        }
        if (j + 1 < n && matrix[i][j + 1] > s) {
            dfs(matrix, m, n, i, j + 1, maxLen);
            res = Math.max(res, maxLen[i][j + 1]);
        }

        maxLen[i][j] = res + 1;
    }
}
