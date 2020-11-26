package com.lynx.everyday;

/**
 * @Author cheng
 * @Date 2020/10/12
 * <p>
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class Partition {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }

        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if (sum % 2 != 0) {
            return false;
        }

        int half = sum >> 1;
        if (max > half) {
            return false;
        }

        boolean[][] dp = new boolean[len][half + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j < half + 1; j++) {
                if (num <= j) {
                    dp[i][j] = dp[i - 1][j - num] | dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][half];
    }
}
