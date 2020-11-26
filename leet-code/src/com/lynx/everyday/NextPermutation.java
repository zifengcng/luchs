package com.lynx.everyday;

import com.lynx.common.annotition.MidCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/10
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * https://leetcode-cn.com/problems/next-permutation/
 */
@MidCode
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int r = nums.length - 1;
        int cur = r - 1;

        // 从右向左递增
        while (cur >= 0 && nums[cur] >= nums[cur + 1]) {
            cur--;
        }

        // 递减序列，反转即可
        if (cur < 0) {
            reverse(nums, 0, r);
            return;
        }

        int k = cur + 2;
        while (k <= r && nums[cur] < nums[k]) {
            k++;
        }
        swap(nums, cur, k - 1);
        reverse(nums, cur + 1, r);
    }

    private void reverse(int[] nums, int l, int r) {
        while (r > l) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();

        // 1,2,3 → 1,3,2
        int[] nums = new int[]{1, 2, 3};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        // 3,2,1 → 1,2,3
        nums = new int[]{3, 2, 1};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        // 1,1,5 → 1,5,1
        nums = new int[]{1, 1, 5};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        // 4,1,3,2,1 -> 4 2113
        nums = new int[]{4, 1, 3, 2, 1};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

        // 4,2,3,2,1 -> 4 3122
        nums = new int[]{4, 2, 3, 2, 1};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));


    }
}
