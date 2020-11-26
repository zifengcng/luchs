package com.lynx.explore.high;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/9/4
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-hard/xdnx6s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = len - 1;
        int mid = (left + right) / 2;

        List<Integer> list = new ArrayList<>();
        if (len % 2 == 0) {
            for (int i = mid; i >= 0; i--) {
                list.add(nums[i]);
                list.add(nums[mid + 1 + i]);
            }
        } else {
            for (int i = 0; i < mid; i++) {
                list.add(nums[i]);
                list.add(nums[mid + 1 + i]);
            }
            list.add(nums[mid]);
        }
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
    }
}
