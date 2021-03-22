package com.lynx.explore.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wbc
 * @date 2020/6/28 17:29
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/1413/
 */
public class MergeArray {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int curr = 0;
        int next = 1;
        while (next < intervals.length) {
            if (intervals[curr][1] >= intervals[next][0]) {
                int min = Math.min(intervals[curr][0], intervals[next][0]);
                int max = Math.max(intervals[curr][1], intervals[next][1]);
                int[] item = {min, max};
                intervals[curr] = item;
            } else {
                intervals[++curr] = intervals[next];
            }
            next++;
        }
        int[][] result = new int[curr + 1][];
        for (int i = 0; i < result.length; i++) {
            result[i] = intervals[i];
        }
        return result;
    }

}
