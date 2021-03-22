package com.lynx.explore.queue;

/**
 * @author wbc
 * @date 2020/7/3 16:11
 * 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[0][1] == '1') {
                    depthSearch(grid, i, j);
                    num++;
                }
            }
        }

        return num;

    }

    private void depthSearch(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        depthSearch(grid, i - 1, j);
        depthSearch(grid, i + 1, j);
        depthSearch(grid, i, j - 1);
        depthSearch(grid, i, j + 1);
    }
}
