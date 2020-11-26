package com.lynx.random;

/**
 * @Author cheng
 * @Date 2020/9/25
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 * <p>
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) {
            return a;
        }
        int[] b = new int[len];

        int[] left = new int[len];
        left[0] = 1;

        int[] right = new int[len];
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        for (int i = 0; i < len; i++) {
            b[i] = left[i] * right[i];
        }
        return b;
    }
}
