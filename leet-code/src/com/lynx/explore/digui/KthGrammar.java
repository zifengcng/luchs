package com.lynx.explore.digui;

/**
 * @author wbc
 * @date 2020/6/28 11:13
 * <p>
 * 第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * <p>
 * 例子:
 * 输入: N = 1, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 1
 * 输出: 0
 * <p>
 * 输入: N = 2, K = 2
 * 输出: 1
 * <p>
 * 输入: N = 4, K = 5
 * 输出: 1
 * <p>
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 第三行: 0110
 * 第四行: 01101001
 * <p>
 * 注意：
 * <p>
 * N 的范围 [1, 30].
 * K 的范围 [1, 2^(N-1)].
 * <p>
 * https://leetcode-cn.com/explore/featured/card/recursion-i/260/conclusion/1231/
 */
public class KthGrammar {

    public int kthGrammar(int N, int K) {
        if (N == 1 || N == 2) {
            return K - 1;
        }
        int half = (int) Math.pow(2, (N - 2));
        if (K > half) {
            return kthGrammar(N, (K - half)) == 0 ? 1 : 0;
        } else {
            return kthGrammar(N - 1, K);
        }
    }
}
