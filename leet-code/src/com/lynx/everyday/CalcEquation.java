package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/1/6
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * <p>
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * <p>
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * <p>
 * <p>
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 示例 2：
 * <p>
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * 示例 3：
 * <p>
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * https://leetcode-cn.com/problems/evaluate-division/
 */
@MidCode
public class CalcEquation {

    // 并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        // 1合并
        UnionFind unionFind = new UnionFind(2 * n);
        Map<String, Integer> map = new HashMap<>(2 * n);
        int id = 0;
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);

            if (!map.containsKey(a)) {
                map.put(a, id++);
            }
            if (!map.containsKey(b)) {
                map.put(b, id++);
            }
            unionFind.union(map.get(a), map.get(b), values[i]);
        }

        // 2查询
        int size = queries.size();
        double[] res = new double[size];
        for (int i = 0; i < size; i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);

            Integer id1 = map.get(a);
            Integer id2 = map.get(b);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }

        return res;
    }

    public class UnionFind {
        private int[] parent;
        private double[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // rank[x] * rank[rootX] = rank[y] * value;
            rank[rootX] = rank[y] * value / rank[x];
        }

        private int find(int x) {
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                rank[x] *= rank[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return rank[x] / rank[y];
            } else {
                return -1.0d;
            }
        }
    }

    public static void main(String[] args) {
        CalcEquation c = new CalcEquation();
        //示例 1：
        //
        //输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        //输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
        //解释：
        //条件：a / b = 2.0, b / c = 3.0
        //问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
        //结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
        double[] values = {2.0, 3.0};
        List<List<String>> equations = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        equations.add(list);
        List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        equations.add(list2);

        String[][] arrays = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        List<List<String>> queries = new ArrayList<>();
        for (String[] array : arrays) {
            queries.add(Arrays.asList(array));
        }

        double[] doubles = c.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(doubles));
    }
}
