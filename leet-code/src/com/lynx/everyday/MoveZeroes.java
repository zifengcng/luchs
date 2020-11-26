package com.lynx.everyday;

import com.lynx.common.annotition.EasyCode;

import java.util.Arrays;

/**
 * @Author cheng
 * @Date 2020/11/19
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * https://leetcode-cn.com/problems/move-zeroes/
 */
@EasyCode
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            // i==j时直接返回，防止x^x=0
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        //示例:
        //
        //输入: [0,1,0,3,12]
        //输出: [1,3,12,0,0]
        int[] nums = {0, 1, 0, 3, 12};
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        //输入：[1,0]
        //预期结果：[1,0]
        nums = new int[]{1, 0};
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        //输入：[2,1]
        //预期结果：[2,1]
        nums = new int[]{2, 1};
        m.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
