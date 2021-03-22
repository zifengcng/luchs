package com.lynx.explore.queue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/10 18:55
 * 钥匙和房间
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/893/
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> locked = new HashSet<>();
        for (int i = 1; i < n; i++) {
            locked.add(i);
        }
        Set<Integer> keys = new HashSet<>(rooms.get(0));
        Set<Integer> tempKeys = new HashSet<>();

        boolean flag = true;

        while (!keys.isEmpty() && flag) {
            flag = false;
            for (Integer key : keys) {
                if (locked.contains(key)) {
                    locked.remove(key);
                    tempKeys.addAll(rooms.get(key));
                    flag = true;
                }
            }
            keys = new HashSet<>(tempKeys);
            tempKeys.clear();
        }

        return locked.isEmpty();
    }

    // dfs
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] opened = new boolean[n];
        opened[0] = true;

        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, opened, visited);
        for (int i = 0; i < n; i++) {
            if (!opened[i]) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index, boolean[] opened, Set<Integer> visited) {
        List<Integer> keys = rooms.get(index);
        if (keys == null || keys.isEmpty()) {
            return;
        }
        keys.forEach(key -> {
            if (visited.contains(key)) {
                return;
            }
            visited.add(key);
            opened[key] = true;
            dfs(rooms, key, opened, visited);
        });
    }
}
