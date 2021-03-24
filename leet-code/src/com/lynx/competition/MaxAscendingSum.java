package com.lynx.competition;

/**
 * @Author cheng
 * @Date 2021/3/23
 * 1800. 最大升序子数组和 显示英文描述
 * 通过的用户数3856
 * 尝试过的用户数3954
 * 用户总通过次数3909
 * 用户总提交次数5621
 * 题目难度Easy
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * 示例 3：
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * 示例 4：
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * https://leetcode-cn.com/contest/weekly-contest-233/problems/maximum-ascending-subarray-sum/
 */

public class MaxAscendingSum {

    public int maxAscendingSum(int[] nums) {
        int len = nums.length;
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                max = Math.max(max, sum);
                sum = nums[i];
            }
        }
        max = Math.max(max, sum);
        return max;
    }
}
