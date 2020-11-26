package com.lynx.explore.primary;

import java.util.BitSet;

/**
 * @Author cheng
 * @Date 2020/8/6
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnzlu6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        BitSet bitSet = new BitSet(n);
        for (int i = 2; i * i < n; i++) {
            if (!bitSet.get(i)) {
                for (int j = i * i; j < n; j += i) {
                    bitSet.set(j);
                }
            }
        }
        return n - 2 - bitSet.cardinality();
    }

}
