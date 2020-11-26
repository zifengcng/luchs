package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

/**
 * @Author cheng
 * @Date 2020/11/3
 * <p>
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * <p>
 * https://leetcode-cn.com/problems/valid-mountain-array/
 */
@EasyCode
public class MountainArray {

    public boolean validMountainArray(int[] A) {
        // 从左向右递增，到最大
        int len = A.length;
        if (len < 3) {
            return false;
        }

        if (A[1] <= A[0]) {
            return false;
        }

        boolean findMax = true;
        for (int i = 1; i < len - 1; i++) {
            if (findMax) {
                // 递增
                if (A[i] == A[i - 1]) {
                    return false;
                } else if (A[i] < A[i - 1]) {
                    findMax = false;
                }
            } else {
                // 递减
                if (A[i] >= A[i - 1]) {
                    return false;
                }
            }
        }

        if (A[len - 2] <= A[len - 1]) {
            return false;
        }

        return true;
    }
}
