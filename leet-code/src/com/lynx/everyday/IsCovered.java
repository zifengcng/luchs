package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author cheng
 * @Date 2021/7/23
 * <p>
 * 1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * <p>
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * <p>
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
@EasyCode
public class IsCovered {


    public boolean isCovered(int[][] ranges, int left, int right) {
        // 方式一：适用于数组较小
        int[] nums = new int[51];
        for (int[] range : ranges) {
            int l = Math.max(range[0], left);
            int r = Math.min(range[1], right);
            for (int j = l; j <= r; j++) {
                nums[j] = 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (nums[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isCovered2(int[][] ranges, int left, int right) {
        // 方式二：区间缩小
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        for (int[] range : ranges) {
            int min = range[0];
            int max = range[1];

            if (left >= min && left <= max) {
                left = max + 1;
            }
            if (right >= min && right <= max) {
                right = min - 1;
            }
            if (left > right) {
                return true;
            }
        }
        return false;
    }

    public boolean isCovered3(int[][] ranges, int left, int right) {
        // 方式二：差分数组前缀和
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }

        int[] sum = new int[52];
        for (int i = 1; i < 52; i++) {
            sum[i] = sum[i-1] + diff[i];
        }

        for (int i = left; i <= right; i++) {
            if (sum[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsCovered i = new IsCovered();
        int[][] ranges = new int[][]{{2, 2}, {3, 3}, {1, 1}};
        System.out.println(i.isCovered2(ranges, 1, 3));
    }
}
