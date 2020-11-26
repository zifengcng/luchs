package com.lynx.random;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author cheng
 * @Date 2020/9/27
 * 1036. 逃离大迷宫
 * 在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 <= x, y < 10^6。
 * <p>
 * 我们从源方格 source 开始出发，意图赶往目标方格 target。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表 blocked 上。
 * <p>
 * 只有在可以通过一系列的移动到达目标方格时才返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 示例 2：
 * <p>
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 * <p>
 * https://leetcode-cn.com/problems/escape-a-large-maze/
 */
public class IsEscapePossible {

    private int[][] next = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private int max = (int) 1e6;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> set = new HashSet<>();
        for (int[] block : blocked) {
            set.add(block[0] + ":" + block[1]);
        }
        if (set.isEmpty()) {
            return true;
        }
        return bfs(source, target, set) && bfs(target, source, set);
    }

    private boolean bfs(int[] source, int[] target, Set<String> set) {
        Set<String> seen = new HashSet<>();
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int[] next : next) {
                int nextX = poll[0] + next[0];
                int nextY = poll[1] + next[1];

                if (nextX < 0 || nextX >= max || nextY < 0 || nextY >= max) {
                    continue;
                }

                String key = nextX + ":" + nextY;
                if (seen.contains(key) || set.contains(key)) {
                    continue;
                }

                if (nextX == target[0] && nextY == target[1]) {
                    return true;
                }

                queue.offer(new int[]{nextX, nextY});
                seen.add(key);
            }

            // 因为 blocked 的 length 是 200
            // 如果使用这 200 个 block 可以围成最大的区域是 19900，如下：
            /*
                0th      _________________________
                        |O O O O O O O X
                        |O O O O O O X
                        |O O O O O X
                        |O O O O X
                        .O O O X
                        .O O X
                        .O X
                200th   |X
            从上面可以计算出 block（即 X）可以围城的最大区域(是一个角的三角形)，大小计算如下：
            1 + 2 + 3 + 4 + ... + 199 = (1 + 199) * 199 / 2 = 19900
            这里我们向上取整为 20000。
            */
            // 也就是说，如果迭代了 20000 步还能继续走的话，那么是肯定可以到达 target 的

            if (seen.size() >= 20000) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsEscapePossible i = new IsEscapePossible();
        int[][] blocked = new int[][]{};
        int[] source = new int[]{0, 0};
        int[] target = new int[]{999999, 999999};
        boolean b = i.isEscapePossible(blocked, source, target);
        System.out.println(b);
    }
}
