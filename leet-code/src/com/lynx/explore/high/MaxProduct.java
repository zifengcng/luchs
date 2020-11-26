package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/7
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdwst3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProduct {

    // dp[i] 记录前i+1个数的最大乘积
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int res = dpMax[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            res = Math.max(res, dpMax[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        MaxProduct maxP = new MaxProduct();
        System.out.println(maxP.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxP.maxProduct(new int[]{2, 3, 0, -2, 4}));
    }
}
