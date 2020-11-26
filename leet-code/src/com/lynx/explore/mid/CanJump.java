package com.lynx.explore.mid;

/**
 * @Author cheng
 * @Date 2020/8/20
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvb8zs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        //2,3,1,1,4
        // dp[3] = true
        // dp[2] = true
        // dp[1] = true
        // dp[0] = true
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;
        for (int i = len - 2; i >= 0; i--) {
            int num = nums[i];
            for (int j = i + 1; j <= i + num; j++) {
                if (j < len && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
