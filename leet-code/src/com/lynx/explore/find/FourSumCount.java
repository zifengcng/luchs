package com.lynx.explore.find;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wbc
 * @date 2020/7/14 10:02
 * 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/239/learn-to-use-keys/997/
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        AtomicInteger res = new AtomicInteger();
        int length = A.length;

        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                m1.merge(sum, 1, Integer::sum);
            }
        }

        Map<Integer, Integer> m2 = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + D[j];
                m2.merge(sum, 1, Integer::sum);
            }
        }

        m1.forEach((k, v) -> {
            Integer count = m2.get(0 - k);
            if (count != null) {
                res.addAndGet(v * count);
            }
        });

        return res.get();
    }

}
