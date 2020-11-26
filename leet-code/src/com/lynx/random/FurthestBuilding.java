package com.lynx.random;

import com.lynx.common.annotition.MidCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author cheng
 * @Date 2020/11/3
 * <p>
 * 1642. 可以到达的最远建筑 显示英文描述
 * 通过的用户数970
 * 尝试过的用户数1435
 * 用户总通过次数996
 * 用户总提交次数2785
 * 题目难度Medium
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * <p>
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * <p>
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * <p>
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * 示例 2：
 * <p>
 * 输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * 输出：7
 * 示例 3：
 * <p>
 * 输入：heights = [14,3,19,3], bricks = 17, ladders = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 105
 * 1 <= heights[i] <= 106
 * 0 <= bricks <= 109
 * 0 <= ladders <= heights.length
 * <p>
 * https://leetcode-cn.com/contest/weekly-contest-213/problems/furthest-building-you-can-reach/
 */
@MidCode
public class FurthestBuilding {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;
        int index = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(len, Comparator.reverseOrder());

        while (index < len) {
            while (index < len - 1 && heights[index + 1] < heights[index]) {
                index++;
            }
            if (index == len - 1) {
                return index;
            }

            int needBricks = heights[index + 1] - heights[index];
            if (bricks >= needBricks) {
                bricks -= needBricks;
                priorityQueue.add(needBricks);
            } else if (ladders > 0) {
                ladders--;
                Integer max = priorityQueue.peek();
                if (max != null && max > needBricks) {
                    bricks += max - needBricks;
                    priorityQueue.poll();
                }
            } else {
                return index;
            }

            index++;
        }

        return index;
    }


    public static void main(String[] args) {
        FurthestBuilding f = new FurthestBuilding();
        System.out.println(f.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
    }
}
