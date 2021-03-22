package com.lynx.explore.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wbc
 * @date 2020/7/14 18:49
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/240/lookup-table-and-sliding-window/1005/
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 0) {
            return false;
        }
        if (k <= 0) {
            return false;
        }
        Map<Integer, Integer> visitedMap = new HashMap<>();

        for (int i = 0; i <= k && i < nums.length; i++) {
            int count = visitedMap.getOrDefault(nums[i], 0) + 1;
            if (count == 2) {
                return true;
            }
            visitedMap.put(nums[i], count);
        }
        for (Integer value : visitedMap.values()) {
            if (value > 1) {
                return true;
            }
        }
        int index = 0;
        for (int i = k + 1; i < nums.length; i++) {
            visitedMap.remove(nums[index++]);

            int count = visitedMap.getOrDefault(nums[i], 0) + 1;
            if (count == 2) {
                return true;
            }
            visitedMap.put(nums[i], count);
        }

        return false;
    }
}
