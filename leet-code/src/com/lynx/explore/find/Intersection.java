package com.lynx.explore.find;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wbc
 * @date 2020/7/13 10:20
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/236/learn-to-use-set/977/
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int i : nums1) {
            s1.add(i);
        }

        for (int i : nums2) {
            if (s1.contains(i)) {
                res.add(i);
            }
        }

        int[] nums = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            nums[index++] = re;
        }
        return nums;
    }
}
