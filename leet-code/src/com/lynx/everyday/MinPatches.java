package com.lynx.everyday;

import com.lynx.common.annotition.HardCode;

/**
 * @Author cheng
 * @Date 2020/12/29
 */
@HardCode
public class MinPatches {

    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        long x = 1;
        int index = 0;
        int patches = 0;
        while (x <= n) {
            if (index < len && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {
        MinPatches p = new MinPatches();
        int n = 6;
        int[] nums = new int[]{1};
        System.out.println(p.minPatches(nums, n));
    }
}
