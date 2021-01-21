package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/1/19
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * <p>
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * <p>
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 * <p>
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 * <p>
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 * <p>
 * 输入：points = [[0,0]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 */
@MidCode
public class MinCostConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        Collections.sort(edges);
        int res = 0;
        int num = 1;
        for (Edge edge : edges) {
            int len = edge.len;
            int x = edge.x;
            int y = edge.y;
            if (dsu.unionSet(x, y)) {
                res += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }

        return res;
    }

    private int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    class DisjointSetUnion {
        int[] parent;
        int[] rank;
        int n;

        public DisjointSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean unionSet(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }

//            if (rank[rootX] < rank[rootY]) {
//                int t = rootX;
//                rootX = rootY;
//                rootY = t;
//            }
//            rank[rootX] += rank[rootY];
//            parent[rootY] = rootX;
            return true;
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

    class Edge implements Comparable<Edge> {
        int len;
        int x;
        int y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }
}
