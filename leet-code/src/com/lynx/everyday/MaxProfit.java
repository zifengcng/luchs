package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 714. 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 注意:
 * <p>
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
@MidCode
public class MaxProfit {

    // 动态规划
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        // dp[i][0]不持有股票的最大收益:a.i-1天不持有股票；b.i-1天持有股票，第i天卖出
        // dp[i][1]持有股票的最大收益：a.i-1天不持有股票,第i天买入；b.i-1天持有股票
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

    // 动态规划，去掉数组
    public int maxProfit3(int[] prices, int fee) {
        int len = prices.length;
        // dp[i][0]不持有股票的最大收益:a.i-1天不持有股票；b.i-1天持有股票，第i天卖出
        // dp[i][1]持有股票的最大收益：a.i-1天不持有股票,第i天买入；b.i-1天持有股票
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < len; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(sell - prices[i], buy);
        }
        return sell;
    }

    // 贪心
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        int carry = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < carry) {
                carry = prices[i];
            } else if (prices[i] - fee > carry) {
                res += prices[i] - fee - carry;

                // 减去手续费：当price[x+1]<price[x+2]-fee<price[x+3]-fee时只交一次手续费
                carry = prices[i] - fee;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        //示例 1:
        //
        //输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
        //输出: 8
        //解释: 能够达到的最大利润:
        //在此处买入 prices[0] = 1
        //在此处卖出 prices[3] = 8
        //在此处买入 prices[4] = 4
        //在此处卖出 prices[5] = 9
        //总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit.maxProfit(prices, fee));

        //示例 2:
        //
        //输入: prices = [1, 4, 3, 8, 4, 9], fee = 2
        //输出: 8
        //总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
        prices = new int[]{1, 4, 3, 8, 4, 9};
        fee = 2;
        System.out.println(maxProfit.maxProfit(prices, fee));

        //示例 3:
        //
        //输入: prices = [1, 5, 9], fee = 2
        //输出: 6
        prices = new int[]{1, 5, 9};
        fee = 2;
        System.out.println(maxProfit.maxProfit(prices, fee));


    }
}
