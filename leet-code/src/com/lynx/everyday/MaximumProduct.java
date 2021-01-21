package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2021/1/20
 * 628. 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
@EasyCode
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    public int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }


    public static void main(String[] args) {
        MaximumProduct m = new MaximumProduct();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(m.maximumProduct(nums));
        nums = new int[]{0, 2, 3, 4};
        System.out.println(m.maximumProduct(nums));
        nums = new int[]{-1, -2, -3, -4};
        System.out.println(m.maximumProduct(nums));
        nums = new int[]{-1, -2, 3, 4};
        System.out.println(m.maximumProduct(nums));
    }
}
