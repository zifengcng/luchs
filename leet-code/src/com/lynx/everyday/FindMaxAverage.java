package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2021/2/4
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 */
@EasyCode
public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = k;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        while (right < n) {
            sum = sum - nums[left] + nums[right];
            max = Math.max(max, sum);
            right++;
            left++;
        }

        return ((double) max) / k;
    }
}
