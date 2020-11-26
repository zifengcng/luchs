package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/8/25
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] state = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    state[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countLife(board, m, n, i, j);
                if (count < 2) {
                    state[i][j] = false;
                } else if (count == 2) {
                    // nothing
                } else if (count == 3) {
                    state[i][j] = true;
                } else {
                    state[i][j] = false;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = state[i][j] ? 1 : 0;
            }
        }
    }

    private int countLife(int[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        int count = isLife(board, m, n, i - 1, j - 1);
        count += isLife(board, m, n, i - 1, j);
        count += isLife(board, m, n, i - 1, j + 1);

        count += isLife(board, m, n, i, j - 1);
        count += isLife(board, m, n, i, j + 1);

        count += isLife(board, m, n, i + 1, j - 1);
        count += isLife(board, m, n, i + 1, j);
        count += isLife(board, m, n, i + 1, j + 1);

        return count;
    }

    private int isLife(int[][] board, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        return board[i][j];
    }
}
