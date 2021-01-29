package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/1/25
 * 959. 由斜杠划分区域
 * 在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。
 * <p>
 * （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。
 * <p>
 * 返回区域的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * " /",
 * "/ "
 * ]
 * 输出：2
 * 解释：2x2 网格如下：
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * [
 * " /",
 * "  "
 * ]
 * 输出：1
 * 解释：2x2 网格如下：
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * [
 * "\\/",
 * "/\\"
 * ]
 * 输出：4
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
 * 2x2 网格如下：
 * <p>
 * 示例 4：
 * <p>
 * 输入：
 * [
 * "/\\",
 * "\\/"
 * ]
 * 输出：5
 * 解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
 * 2x2 网格如下：
 * <p>
 * 示例 5：
 * <p>
 * 输入：
 * [
 * "//",
 * "/ "
 * ]
 * 输出：3
 * 解释：2x2 网格如下：
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 30
 * grid[i][j] 是 '/'、'\'、或 ' '。
 * https://leetcode-cn.com/problems/regions-cut-by-slashes/
 */
@MidCode
public class RegionsBySlashes {

    // 单元格根据/，\分割成4个△
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4 * n * n;

        UnionFind unionFind = new UnionFind(size);

        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = chars[j];
                // 单元格内合并
                if (c == '/') {
                    // 合并0-3,1-2
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if (c == '\\') {
                    // 合并0-1,2-3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else {
                    // 合并0-1-2-3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右 1->下个单元格3
                if (j + 1 < n) {
                    unionFind.union(index + 1, 4 * (i * n + j + 1) + 3);
                }
                // 向下 2->下个单元格0
                if (i + 1 < n) {
                    unionFind.union(index + 2, 4 * ((i + 1) * n + j));
                }
            }
        }

        return unionFind.count;
    }

    class UnionFind {
        int count;
        int[] parent;

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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

            parent[rootX] = rootY;
            count--;
        }
    }
}
