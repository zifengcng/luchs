package com.lynx.explore.primary;

/**
 * @author wbc
 * @date 2020/8/4 9:51
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProfit3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int res = 0;
		for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            res = Integer.max(res, prices[i] - min);
		}
        return res;

    }

    private int getMaxProfit(int[] prices, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int i = l;
        int j = r;
        int res = 0;
        while (true) {
            while (i + 1 < j && prices[i + 1] < prices[i]) {
                i++;
            }
            while (j - 1 > i && prices[j - 1] > prices[j]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int s = prices[j] - prices[i];
			res = Integer.max(res, s);
			res = Integer.max(res, getMaxProfit(prices, i + 1, j));
			res = Integer.max(res, getMaxProfit(prices, i, j - 1));
			i++;
			j--;
		}

        return res;
    }

    public static void main(String[] args) {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        int[] prices = {9,9,0,3,0,7,7,7,4,1,5,0,1,7};
        int i = maxProfit3.maxProfit(prices);
        System.out.println(i);
    }
}
