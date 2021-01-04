package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

/**
 * @Author cheng
 * @Date 2020/12/28
 * 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= k <= 109
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
@HardCode
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        if (k > len / 2) {
            // 最多为len/2笔交易，此时k代表可以代表正无穷大
            return maxProfitForInfinity(prices);
        }
        /*
          0未持有，1持有
          dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
          表示第i天最大交易了k笔且未持有股票时的收益

          dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
          表示第i天最大交易了k笔且持有股票时的收益
         */
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            // dp[0][0][0] = -price[0]
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    if (j == 1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    }
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][k][0];
    }

    private int maxProfitForInfinity(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        MaxProfitIV m = new MaxProfitIV();
        int k = 2;
        int[] prices = new int[]{2,4,1};
        System.out.println(m.maxProfit(k, prices));

        k = 2;
        prices = new int[]{3, 2, 6, 5, 0, 3};
        System.out.println(m.maxProfit(k, prices));

        k = 4;
        prices = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(m.maxProfit(k, prices));

    }
}
