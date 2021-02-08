package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

/**
 * @Author cheng
 * @Date 2021/2/8
 * 978. 最长湍流子数组
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
@MidCode
public class MaxTurbulenceSize {

    // 滑动窗口
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return len;
        }

        int left = 0;
        int right = 0;

        int max = 1;
        while (right < len - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // dp
    public int maxTurbulenceSize2(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return len;
        }

        // dp[i][0] 表示以i为结尾时连续的湍流子数组的长度：若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
        // dp[i][1] 表示以i为结尾时连续的湍流子数组的长度：若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
        // dp[i][k] = dp[i-1][k]+1
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            if (arr[i - 1] < arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] > arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            max = Math.max(max, dp[i][0]);
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }


    public static void main(String[] args) {
        MaxTurbulenceSize m = new MaxTurbulenceSize();
        //示例 1：
        //
        //输入：[9,4,2,10,7,8,8,1,9]
        //输出：5
        //解释：(A[1] > A[2] < A[3] > A[4] < A[5])
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(m.maxTurbulenceSize2(arr) == 5);

        //示例 2：
        //
        //输入：[9,9]
        //输出：1
        arr = new int[]{9, 9};
        System.out.println(m.maxTurbulenceSize2(arr) == 1);


    }
}
