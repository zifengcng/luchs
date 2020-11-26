package com.lynx.explore.high;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/8/28
 * 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * <p>
 * Java
 * <p>
 * <p>
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xwfor1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SurroundAreas {

    public void solve(char[][] board) {
        int m = board.length;
        if (board.length < 2) {
            return;
        }
        int n = board[0].length;
        if (board[0].length < 2) {
            return;
        }

        for (int i = 0; i < m; i++) {
            dfs(board, m, n, i, 0);
            dfs(board, m, n, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, m, n, 0, i);
            dfs(board, m, n, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';
        dfs(board, m, n, i - 1, j);
        dfs(board, m, n, i + 1, j);
        dfs(board, m, n, i, j - 1);
        dfs(board, m, n, i, j + 1);
    }

    public static void main(String[] args) {
        SurroundAreas s = new SurroundAreas();
        char[][] board = {{'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        s.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        System.out.println(Arrays.asList(board));
    }
}
