package com.lynx.explore.mid;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/8/20
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvf0kh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        /**
         * dp[amount] = dp[amount-x] + 1;
         */
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
