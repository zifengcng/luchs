package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2020/11/27
 * 454. 四数相加 II
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
 * https://leetcode-cn.com/problems/4sum-ii/
 */
@MidCode
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>(len * len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                Integer count = map.getOrDefault(sum, 0);
                map.put(sum, count + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res += map.getOrDefault(-C[i] - D[j], 0);
            }
        }

        return res;
    }
}
