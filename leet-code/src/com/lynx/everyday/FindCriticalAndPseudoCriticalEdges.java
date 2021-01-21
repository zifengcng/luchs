package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/1/21
 * 1489. 找到最小生成树里的关键边和伪关键边
 * 给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。
 * <p>
 * 请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
 * <p>
 * 请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
 * 输出：[[0,1],[2,3,4,5]]
 * 解释：上图描述了给定图。
 * 下图是所有的最小生成树。
 * <p>
 * 注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
 * 边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
 * 输出：[[],[0,1,2,3]]
 * 解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= min(200, n * (n - 1) / 2)
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti <= 1000
 * 所有 (fromi, toi) 数对都是互不相同的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@HardCode
public class FindCriticalAndPseudoCriticalEdges {

    //关键边：如果最小生成树中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
    //        设原图的做小生成树的权值为value,则去掉这条边后：
    //          a:要么整个图不连通，不存在最小生成树
    //          b:要么整个图连通，对应的最小生成树的权值为v,且v严格大于value
    //伪关键边：可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边.
    //         在计算最小生成树的过程中，最先考虑这条边，即最先将这条边的两个端点在并查集中合并。
    //        设最终得到的最小生成树权值为v, 如果v=value,则这条边就是伪关键边。
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 边排序
        int len = edges.length;
        Map<String, Integer> edgeToIndexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] edge = edges[i];
            edgeToIndexMap.put(edge[0] + "-" + edge[1], i);
        }
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        // 最小生成数的权值
        int value = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            if (unionFind.union(edge[0], edge[1])) {
                value += edge[2];
            }
        }
        System.out.println(value);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            UnionFind uf = new UnionFind(n);
            int v = 0;
            // 关键边
            for (int j = 0; j < len; j++) {
                if (j != i && uf.union(edges[j][0], edges[j][1])) {
                    v += edges[j][2];
                }
            }
            if (uf.setCount != 1 || v > value) {
                res.get(0).add(edgeToIndexMap.get(edges[i][0] + "-" + edges[i][1]));
                // 是关键边了就不会是伪关键边了，所以continue
                continue;
            }

            // 伪关键边
            uf = new UnionFind(n);
            uf.union(edges[i][0], edges[i][1]);
            v = edges[i][2];
            for (int j = 0; j < len; j++) {
                if (j != i && uf.union(edges[j][0], edges[j][1])) {
                    v += edges[j][2];
                }
            }
            if (v == value) {
                res.get(1).add(edgeToIndexMap.get(edges[i][0] + "-" + edges[i][1]));
            }

        }

        return res;
    }

    class UnionFind {
        int n;
        int[] parent;
        int[] rank;
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            setCount = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x, int y) {
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
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }
            setCount--;
            return true;
        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
