package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/9
 * 327. 区间和的个数
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * https://leetcode-cn.com/problems/count-of-range-sum/
 */
@HardCode
public class CountRangeSum {

    // TODO
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int res = 0;
        int total = Arrays.stream(nums).sum();

        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum >= lower && sum <= upper) {
                res++;
            }
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountRangeSum c = new CountRangeSum();
        // 3
        System.out.println(c.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
