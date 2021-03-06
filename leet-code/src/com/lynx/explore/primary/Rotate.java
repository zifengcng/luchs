package com.lynx.explore.primary;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/29 16:05
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (k == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; count < len; i++) {
            int prev = nums[i];
            int cur = i;
            do {
                int next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (i != cur);
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
