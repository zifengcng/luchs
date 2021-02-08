package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2021/2/7
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * https://leetcode-cn.com/problems/non-decreasing-array/
 */
@EasyCode
public class CheckPossibility {

    // (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;

        int prev = Integer.MIN_VALUE;
        int changeLen = 0;
        for (int i = 0; i < len - 1; i++) {
            // 如果当前节点比后一个节点大
            if (nums[i] > nums[i + 1]) {
                // 比较prev和next
                if (prev > nums[i + 1]) {
                    // 修改next节点
                    nums[i + 1] = nums[i];
                } else {
                    // 修改当前节点
                    nums[i] = prev;
                }
                changeLen++;
            }
            prev = nums[i];
            if (changeLen > 1) {
                return false;
            }
        }
        return true;
    }
}
