package com.lynx.explore.array;

/**
 * @author wbc
 * @date 2020/7/2 11:30
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/785/
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        int length = numbers.length;
        int k = length - 1;
        for (int i = 0; i < length; i++) {
            int temp = target - numbers[i];
            for (int j = k; j > i; j--) {
                if (numbers[j] > temp) {
                    k--;
                }
                if (numbers[j] == temp) {
                    indexs[0] = i + 1;
                    indexs[1] = j + 1;
                    return indexs;
                }
            }
            if (k <= i) {
                break;
            }
        }
        return indexs;
    }
}
