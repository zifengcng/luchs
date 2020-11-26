package com.lynx.everyday;

/**
 * @Author cheng
 * @Date 2020/10/16
 * <p>
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * <p>
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class SortedSquares {

    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];

        int l = 0;
        int r = len - 1;

        int i = len - 1;
        while (i >= 0) {
            int c = Math.abs(A[r]) - Math.abs(A[l]);
            if (c > 0) {
                res[i] = A[r] * A[r];
                r--;
            } else {
                res[i] = A[l] * A[l];
                l++;
            }
            i--;
        }

        return res;
    }
}
