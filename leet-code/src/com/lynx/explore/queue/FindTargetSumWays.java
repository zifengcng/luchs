package com.lynx.explore.queue;

/**
 * @author wbc
 * @date 2020/7/9 18:13
 * 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        return count(nums, 0, nums.length - 1, S);
    }

    private int count(int[] nums, int i, int j, int s) {
        int c = 0;
        if (i == j) {
            if (nums[i] == s) {
                c++;
            }
            if (nums[i] == -s) {
                c++;
            }
            return c;
        }

        if (i < j) {
            int c1 = count(nums, i + 1, j, s - nums[i]);
            int c2 = count(nums, i + 1, j, s + nums[i]);
            if (c1 != 0) {
                c += c1;
            }
            if (c2 != 0) {
                c += c2;
            }
        }

        return c;
    }


}
