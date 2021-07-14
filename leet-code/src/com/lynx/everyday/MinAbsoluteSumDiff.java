package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/7/14
 * <p>
 * 1818. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * <p>
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * <p>
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * <p>
 * |x| 定义为：
 * <p>
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,7,5], nums2 = [2,3,5]
 * 输出：3
 * 解释：有两种可能的最优方案：
 * - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
 * - 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
 * 两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * 输出：0
 * 解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * 输出：20
 * 解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
 * 绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 105
 * <p>
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 */
@MidCode
public class MinAbsoluteSumDiff {

    // 排序 + 二分查找
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int MOD = 1000000007;

        int[] src = new int[n];
        System.arraycopy(nums1, 0, src, 0, n);
        Arrays.sort(src);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;

            int j = binarySearch(src, nums2[i]);
            if (j < n) {
                max = Math.max(max, diff - (src[j] - nums2[i]));
            }
            if (j > 0) {
                max = Math.max(max, diff - (nums2[i] - src[j - 1]));
            }
        }

        return (sum - max + MOD) % MOD;
    }

    private int binarySearch(int[] src, int target) {
        int low = 0;
        int high = src.length - 1;
        if (src[high] < target) {
            return high + 1;
        }

        while (low < high) {
            int mid = (low + high) >> 1;
            if (src[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        MinAbsoluteSumDiff m = new MinAbsoluteSumDiff();
        int[] nums1 = new int[]{1, 7, 5};
        int[] nums2 = new int[]{2, 3, 5};
        System.out.println(m.minAbsoluteSumDiff(nums1, nums2) == 3);

    }
}
