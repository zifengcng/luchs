package com.lynx.explore.array;

import java.util.Arrays;

/**
 * @author wbc
 * @date 2020/7/2 13:46
 * 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [3,2,2,3], val = 3,
 * <p>
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * <p>
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * <p>
 * 注意这五个元素可为任意顺序。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/787/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] != val) {
                i++;
            } else {
                if (j < i) {
                    j = i + 1;
                }
                if (j >= length) {
                    break;
                }
                if (nums[j] != val) {
                    swap(nums, i, j);
                    i++;
                } else {
                    j++;
                }
            }
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        r.removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
