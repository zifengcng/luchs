package com.lynx.explore.high;

/**
 * @Author cheng
 * @Date 2020/9/7
 * 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xddkum/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][0] 第i天交易完成后，持有股票，对应的最大累计收益
        // dp[i][1] 第i天交易完成后，不持有股票，处于冷冻期，对应的最大累计收益
        // dp[i][0] 第i天交易完成后，不持有股票，不处于冷冻期，对应的最大累计收益

        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }


        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{6, 1, 3, 2, 4, 7}));
    }

}
