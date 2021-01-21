package com.luchs.java.algorithm;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/1/20
 */
public class ZeroOneQuestion {

    //问题：有N件物品和一个容量为V 的背包。放入第i件物品耗费的空间是Ci，得到
    //的价值是Wi。求解将哪些物品装入背包可使价值总和最大。

    // c[0]为填充
    // 时间复杂度：O(n*v)
    // 空间复杂度：O(n*v)
    public int maxWeight(int v, int[] c, int[] w) {
        int len = c.length;
        int[][] dp = new int[len][v + 1];
//        // 如果需要恰好装满时：
//        for (int i = 0; i < len; i++) {
//            for (int j = 1; j < v + 1; j++) {
//                dp[i][j] = Integer.MIN_VALUE;
//            }
//        }

        for (int i = 1; i < len; i++) {
            for (int j = c[i]; j <= v; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + w[i]);
            }
        }

        return dp[len - 1][v];
    }

    // c[0]为填充
    // 时间复杂度：O(n*v)
    // 空间复杂度：O(v)
    public int maxWeight2(int v, int[] c, int[] w) {
        int len = c.length;
        int[] dp = new int[v + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i < len; i++) {
            for (int j = v; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }

        return dp[v];
    }


    public static void main(String[] args) {
        ZeroOneQuestion z = new ZeroOneQuestion();
        int[] c = new int[]{0, 1, 2, 3, 4, 5};
        int[] w = new int[]{0, 5, 4, 3, 2, 1};
        System.out.println(z.maxWeight(11, c, w));
    }
}
