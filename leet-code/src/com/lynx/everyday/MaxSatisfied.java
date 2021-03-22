package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/2/23
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 */
@MidCode
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int len = customers.length;

        // leftSum[i+1]记录第i分钟grumpy[i]==1时累计不满意的人数
        int[] leftSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                leftSum[i + 1] = leftSum[i];
            } else {
                leftSum[i + 1] = leftSum[i] + customers[i];
            }
        }

        int left = 0;
        int right = X;

        int max = 0;

        while (right <= len) {
            max = Math.max(max, leftSum[right] - leftSum[left]);
            left++;
            right++;
        }

        return sum + max;
    }
}
