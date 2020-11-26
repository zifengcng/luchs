package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/21
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwhvq3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Integer.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            max = Integer.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int i = l.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
