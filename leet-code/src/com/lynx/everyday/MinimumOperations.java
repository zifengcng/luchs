package com.lynx.everyday;

/**
 * @Author cheng
 * @Date 2020/10/12
 * <p>
 * LCP 19. 秋叶收藏集
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 * <p>
 * 示例 1：
 * <p>
 * 输入：leaves = "rrryyyrryyyrr"
 * <p>
 * 输出：2
 * <p>
 * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
 * <p>
 * 示例 2：
 * <p>
 * 输入：leaves = "ryr"
 * <p>
 * 输出：0
 * <p>
 * 解释：已符合要求，不需要额外操作
 * <p>
 * 提示：
 * <p>
 * 3 <= leaves.length <= 10^5
 * leaves 中只包含字符 'r' 和字符 'y'
 * <p>
 * https://leetcode-cn.com/problems/UlBDOe/
 */
public class MinimumOperations {

    public int minimumOperations(String leaves) {
        char[] chars = leaves.toCharArray();
        int len = chars.length;

        int[][] dp = new int[len][3];
        dp[0][0] = chars[0] == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            int isYellow = chars[i] == 'y' ? 1 : 0;
            int isRed = chars[i] == 'r' ? 1 : 0;

            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed;

            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
            }
        }

        return dp[len - 1][2];
    }

    public static void main(String[] args) {
        MinimumOperations m = new MinimumOperations();
        int count = m.minimumOperations("yry");
        System.out.println(count);
    }

}
