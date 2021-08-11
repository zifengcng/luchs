package com.lynx.everyday;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author cheng
 * @Date 2021/8/6
 * <p>
 * 847. 访问所有节点的最短路径
 * 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * <p>
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * <p>
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：graph = [[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一种可能的路径为 [1,0,2,0,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一种可能的路径为 [0,1,4,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] 不包含 i
 * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
 * 输入的图总是连通图
 * <p>
 * https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/
 */
public class ShortestPathLength {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(d[i], n + 1);
        }
        for (int i = 0; i < n; ++i) {
            for (int j : graph[i]) {
                d[i][j] = 1;
            }
        }
        // 使用 floyd 算法预处理出所有点对之间的最短路径长度
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        int[][] f = new int[n][1 << n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int mask = 1; mask < (1 << n); ++mask) {
            // 如果 mask 只包含一个 1，即 mask 是 2 的幂
            if ((mask & (mask - 1)) == 0) {
                // X&(-X):
                //当一个偶数与它的负值相与时，结果是能被这个偶数整除的最大的2的n次幂
                //当一个奇数与它的负值向与时结果一定是1.
                int u = Integer.bitCount((mask & (-mask)) - 1);
                f[u][mask] = 0;
            } else {
                for (int u = 0; u < n; ++u) {
                    if ((mask & (1 << u)) != 0) {
                        for (int v = 0; v < n; ++v) {
                            if ((mask & (1 << v)) != 0 && u != v) {
                                f[u][mask] = Math.min(f[u][mask], f[v][mask ^ (1 << u)] + d[v][u]);
                            }
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int u = 0; u < n; ++u) {
            ans = Math.min(ans, f[u][(1 << n) - 1]);
        }
        return ans;
    }

    // 广度优先遍历 bfs
    public int shortestPathLength2(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int u = poll[0];
            int mask = poll[1];
            int dist = poll[2];
            if (mask == (1 << n) - 1) {
                // 所有的节点都遍历了
                ans = dist;
                break;
            }

            for (int v : graph[u]) {
                // 第v位置为1，表示第v个节点已被扫描
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }

        }

        return ans;
    }
}
