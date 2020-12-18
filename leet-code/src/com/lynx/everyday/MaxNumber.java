package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/12/2
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * <p>
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 * <p>
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 * <p>
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 * https://leetcode-cn.com/problems/create-maximum-number/
 */
@HardCode
public class MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return helper(nums1, nums2, k);
    }

    private int[] helper(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        int m = nums1.length;
        int n = nums2.length;

        // nums1中选取x个数组成k个数
        int x = 0;
        while (x <= m) {
            int newK = k - x;
            if (newK <= n && newK >= 0) {
                int[] mMaxNum = getMaxNum(nums1, m, x);
                int[] nMaxNum = getMaxNum(nums2, n, newK);
                int[] newMax = getMax(mMaxNum, nMaxNum, k);
                boolean compare = compareArr(newMax, 0, k, max, 0, k);
                if (compare) {
                    max = newMax;
                }
            }
            x++;
        }

        return max;
    }

    /**
     * 合并两个数组，并保证两数组的元素的相对顺序，使得组成的数最大
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k
     * @return 最大数
     */
    private int[] getMax(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];

        int len1 = nums1.length;
        int len2 = nums2.length;

        int start1 = 0;
        int start2 = 0;

        for (int i = 0; i < k; i++) {
            boolean compare = compareArr(nums1, start1, len1, nums2, start2, len2);
            if (compare) {
                res[i] = nums1[start1++];
            } else {
                res[i] = nums2[start2++];
            }
        }

        return res;
    }

    private boolean compareArr(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2) {
        if (start1 == len1) {
            return false;
        } else if (start2 == len2) {
            return true;
        } else {
            if (nums1[start1] > nums2[start2]) {
                return true;
            } else if (nums1[start1] < nums2[start2]) {
                return false;
            }
            return compareArr(nums1, start1 + 1, len1, nums2, start2 + 1, len2);
        }
    }

    /**
     * 从数组中选取连续x个数组成最大数
     *
     * @param nums 数组
     * @param len
     * @param x    选取个数
     * @return 最大数
     */
    private int[] getMaxNum(int[] nums, int len, int x) {
        int[] max = new int[x];
        dfsMaxNum(max, 0, x, nums, 0, len, x);
        return max;
    }

    private void dfsMaxNum(int[] max, int index, int x, int[] nums, int l, int r, int curX) {
        if (index == x) {
            return;
        }
        int last = r - curX;
        int maxIndex = l;
        for (int i = l + 1; i <= last; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        max[index++] = nums[maxIndex];
        dfsMaxNum(max, index, x, nums, maxIndex + 1, r, curX - 1);
    }

    public static void main(String[] args) {
        MaxNumber m = new MaxNumber();

        //示例 1:
        //
        //输入:
        //nums1 = [3, 4, 6, 5]
        //nums2 = [9, 1, 2, 5, 8, 3]
        //k = 5
        //输出:
        //[9, 8, 6, 5, 3]
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        int k = 5;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));

        //示例 2:
        //
        //输入:
        //nums1 = [6, 7]
        //nums2 = [6, 0, 4]
        //k = 5
        //输出:
        //[6, 7, 6, 0, 4]
        nums1 = new int[]{6, 7};
        nums2 = new int[]{6, 0, 4};
        k = 5;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));

        //示例 3:
        //
        //输入:
        //nums1 = [3, 9]
        //nums2 = [8, 9]
        //k = 3
        //输出:
        //[9, 8, 9]
        nums1 = new int[]{3, 9};
        nums2 = new int[]{8, 9};
        k = 3;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));


        //示例 4:
        //
        //输入:
        //nums1 = [9,1,2,5,8,3]
        //nums2 = [3,4,6,5]
        //k = 5
        //输出:
        //[9, 8, 6, 5, 3]
        nums1 = new int[]{9, 1, 2, 5, 8, 3};
        nums2 = new int[]{3, 4, 6, 5};
        k = 5;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));


        //示例 5
        //
        //输入:
        //nums1 = [5,6,8]
        //nums2 = [6,4,0]
        //k = 3
        //输出:
        //[8, 6, 4]
        nums1 = new int[]{5, 6, 8};
        nums2 = new int[]{6, 4, 0};
        k = 3;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));

        //示例 6
        //
        //输入:
        //nums1 = [8,5,9,5,1,6,9]
        //nums2 = [2,6,4,3,8,4,1,0,7,2,9,2,8]
        //k = 20
        //输出:
        //[8, 5, 9, 5, 2, 6, 4, 3, 8, 4, 1, 6, 9, 1, 0, 7, 2, 9, 2, 8]
        nums1 = new int[]{8, 5, 9, 5, 1, 6, 9};
        nums2 = new int[]{2, 6, 4, 3, 8, 4, 1, 0, 7, 2, 9, 2, 8};
        k = 20;
        System.out.println(Arrays.toString(m.maxNumber(nums1, nums2, k)));


    }
}
