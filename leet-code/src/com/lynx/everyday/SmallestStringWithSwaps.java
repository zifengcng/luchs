package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2021/1/11
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
 */
@MidCode
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            Integer index1 = pair.get(0);
            Integer index2 = pair.get(1);
            unionFind.union(index1, index2);
        }

        char[] chars = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            map.computeIfAbsent(root, key -> new PriorityQueue<>()).add(chars[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }


    class UnionFind {
        private int[] parent;
        /**
         * 以i为根节点的子树的高度（引入路径压缩以后该定义不准确）
         */
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
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
            } else {
                parent[rootY] = rootX;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }


    public static void main(String[] args) {
        SmallestStringWithSwaps s = new SmallestStringWithSwaps();
        // "dcab"
        //[[0,3],[1,2],[0,2]]
        // abcd
        Integer[][] indexes = new Integer[][]{{0, 3}, {1, 2}, {0, 2}};
        List<List<Integer>> list = new ArrayList<>();
        for (Integer[] index : indexes) {
            list.add(Arrays.asList(index));
        }
        System.out.println(s.smallestStringWithSwaps("dcab", list));

        // "cba"
        //[[0,1],[1,2]]
        // abc
        indexes = new Integer[][]{{0, 1}, {1, 2}};
        list = new ArrayList<>();
        for (Integer[] index : indexes) {
            list.add(Arrays.asList(index));
        }
        System.out.println(s.smallestStringWithSwaps("cba", list));


    }
}
