package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/28 15:26
 * <p>
 * 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 示例 1：
 * <p>
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftS = 0;
        int rightS = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftS = 0;
            } else {
                leftS += nums[i - 1];
            }
            rightS = sum - leftS - nums[i];
            if (leftS == rightS) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int[] nums = {-1, -1, 0, 1, 1, 0};
        int i = pivotIndex.pivotIndex(nums);
        System.out.println(i);
    }
}
