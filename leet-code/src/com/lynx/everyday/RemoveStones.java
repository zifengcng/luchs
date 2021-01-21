package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/1/15
 * 947. 移除最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * <p>
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * <p>
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 * 示例 2：
 * <p>
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 * 示例 3：
 * <p>
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 1000
 * 0 <= xi, yi <= 104
 * 不会有两块石头放在同一个坐标点上
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 */
@MidCode
public class RemoveStones {

    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for (int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }

        return stones.length - unionFind.getCount();
    }

    public class UnionFind {

        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            count--;
        }

        private int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }
    }


    public static void main(String[] args) {
        RemoveStones r = new RemoveStones();
        //示例 1：
        //
        //输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
        //输出：5
        //解释：一种移除 5 块石头的方法如下所示：
        //1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
        //2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
        //3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
        //4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
        //5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
        //石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
        int[][] stones = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(r.removeStones(stones));

        //示例 2：
        //
        //输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
        //输出：3
        //解释：一种移除 3 块石头的方法如下所示：
        //1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
        //2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
        //3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
        //石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
        stones = new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println(r.removeStones(stones));

        //输入：
        //[[0,1],[1,2],[1,3],[3,3],[2,3],[0,2]]
        //预期结果：
        //5
        stones = new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}};
        System.out.println(r.removeStones(stones));

        //输入：
        //[[1,2],[1,3],[3,3],[3,1],[2,1],[1,0]]
        //预期结果：
        //5
        stones = new int[][]{{1, 2}, {1, 3}, {3, 3}, {3, 1}, {2, 1}, {1, 0}};
        System.out.println(r.removeStones(stones));


    }
}
