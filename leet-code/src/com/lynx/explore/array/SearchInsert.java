package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/6/28 16:24
 * <p>
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/1412/
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int i = new SearchInsert().searchInsert(nums, 7);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (i < nums.length - 1) {
                if (nums[i] < target && target < nums[i + 1]) {
                    return i + 1;
                }
            }

        }
        return nums.length;
    }


}
