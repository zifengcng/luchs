package com.lynx.explore.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wbc
 * @date 2020/7/13 10:20
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * https://leetcode-cn.com/explore/orignial/card/all-about-lockup-table/237/learn-to-use-dict/983/
 */
public class Intersection2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int index = 0;
        int c1;
        int c2;
        for (int i = 0; i < nums1.length; i++) {
            c1 = 1;
            c2 = 0;
            while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) {
                i++;
                c1++;
            }
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    c2++;
                    index++;
                }
            }
            if (c2 > 0) {
                int min = Math.min(c1, c2);
                for (int j = 0; j < min; j++) {
                    list.add(nums1[i]);
                }
            }
        }

        int[] nums = new int[list.size()];
        index = 0;
        for (Integer num : list) {
            nums[index++] = num;
        }
        return nums;
    }
}
