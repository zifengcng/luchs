package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2021/1/29
 * 1631. 最小体力消耗路径
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 */
@MidCode
public class MinimumEffortPath {

    // Dijstra（迪杰斯特拉）算法
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int rows = heights.length;
        int columns = heights[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
        queue.offer(new int[]{0, 0, 0});

        int[] dist = new int[rows * columns];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[] seen = new boolean[rows * columns];
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int x = edge[0];
            int y = edge[1];
            int v = edge[2];
            int id = x * columns + y;
            if (seen[id]) {
                continue;
            }
            seen[id] = true;
            if (x == rows - 1 && y == columns - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < columns) {
                    if (Math.max(v, Math.abs(heights[x][y] - heights[newX][newY])) < dist[newX * columns + newY]) {
                        // 松弛
                        dist[newX * columns + newY] = Math.max(v, Math.abs(heights[x][y] - heights[newX][newY]));
                        queue.offer(new int[]{newX, newY, dist[newX * columns + newY]});
                    }
                }
            }

        }

        return dist[rows * columns - 1];
    }

    // 并查集
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge[2]));
        UnionFind unionFind = new UnionFind(m * n);
        int res = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int v = edge[2];
            int id = x * n + y;
            unionFind.union(x, y);
            if (unionFind.connection(0, m * n - 1)) {
                res = v;
                break;
            }
        }

        return res;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
        }

        public boolean connection(int x, int y) {
            return find(x) == find(y);
        }
    }
}
