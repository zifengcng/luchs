package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/12
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
@EasyCode
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int j = 1;
        for (int i = 0; i < len; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    public static void main(String[] args) {
        SortArrayByParityII s = new SortArrayByParityII();
        // 2, 1, 4, 3, 6, 5, 8, 7
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{1, 2, 3, 4, 5, 6, 7, 8})));
        // 2, 1, 4, 3, 6, 5, 8, 7
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{2, 1, 4, 3, 6, 5, 8, 7})));

        // 2, 1, 4, 3, 6, 5, 8, 7
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{2, 4, 6, 8, 1, 3, 5, 7})));
        // 2, 1, 4, 3
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{3, 1, 4, 2})));

        // 3,2,3,2
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{3, 3, 2, 2})));

        // 4,5,2,7
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4, 2, 5, 7})));

    }
}
